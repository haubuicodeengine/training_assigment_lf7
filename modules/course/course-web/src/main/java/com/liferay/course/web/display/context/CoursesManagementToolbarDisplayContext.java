package com.liferay.course.web.display.context;

import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.constants.CommonConstants;
import com.liferay.course.web.constants.CoursePortletConstants;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

/**
 * Courses management toolbar display context. This class passes contextual
 * information to the user interface for the Clay management toolbar.
 *
 * @author liferay
 */
public class CoursesManagementToolbarDisplayContext
	extends BaseManagementToolbarDisplayContext {

	public CoursesManagementToolbarDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest httpServletRequest) {

		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest);

		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
			liferayPortletRequest);
	}

	/**
	 * Returns the creation menu for the toolbar (plus sign on the management
	 * toolbar).
	 *
	 * @return creation menu
	 */
	public CreationMenu getCreationMenu() {

		return new CreationMenu() {

			{
				addDropdownItem(dropdownItem -> {

					dropdownItem.setHref(
						getPortletURL(),
						CommonConstants.PARAM_MVC_RENDER_COMMAND_NAME,
						CoursePortletConstants.COURSE_COMMAND_EDIT_COURSE,
						CommonConstants.REDIRECT, currentURLObj.toString());

					dropdownItem.setLabel(
						LanguageUtil.get(
							request, CoursePortletConstants.KEY_ADD_COURSE));
				});
			}
		};
	}

	@Override
	public String getClearResultsURL() {

		return getSearchActionURL();
	}

	/**
	 * Returns the course list display style. Current selection is stored in
	 * portal preferences.
	 * @return current display style
	 */
	public String getDisplayStyle() {

		String displayStyle =
			ParamUtil.getString(request, CommonConstants.PARAM_DISPLAY_STYLE);

		if (Validator.isNull(displayStyle)) {
			displayStyle = _portalPreferences.getValue(
				CoursePortletKeys.COURSE,
				CoursePortletConstants.PARAM_COURSES_DISPLAY_STYLE,
				CoursePortletConstants.DEFAULT_COURSE_DISPLAY_STYLE);
		}
		else {
			_portalPreferences.setValue(
				CoursePortletKeys.COURSE,
				CoursePortletConstants.PARAM_COURSES_DISPLAY_STYLE,
				displayStyle);

			request.setAttribute(
				WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
		}

		return displayStyle;
	}

	/**
	 * Returns the sort order column.
	 *
	 * @return sort column
	 */
	public String getOrderByCol() {

		return ParamUtil.getString(
			request, CommonConstants.PARAM_ORDER_BY_COL,
			CoursePortletConstants.COURSE_COLUMN_NAME);
	}

	/**
	 * Returns the sort type (ascending / descending).
	 *
	 * @return sort type
	 */
	public String getOrderByType() {

		return ParamUtil.getString(
			request, CommonConstants.PARAM_ORDER_BY_TYPE,
			CommonConstants.SORT_ASC);
	}

	/**
	 * Returns the action URL for the search.
	 *
	 * @return search action URL
	 */
	@Override
	public String getSearchActionURL() {

		PortletURL searchURL = getPortletURL();

		searchURL.setProperty(
			CommonConstants.PARAM_MVC_RENDER_COMMAND_NAME,
			CoursePortletConstants.COURSE_COMMAND_VIEW_COURSES);

		String navigation = ParamUtil.getString(
			request, getNavigationParam(),
			CoursePortletConstants.DEFAULT_PARAM_NAVIGATION);

		searchURL.setParameter(getNavigationParam(), navigation);

		searchURL.setParameter(
			CommonConstants.PARAM_ORDER_BY_COL, getOrderByCol());
		searchURL.setParameter(
			CommonConstants.PARAM_ORDER_BY_TYPE, getOrderByType());

		return searchURL.toString();
	}

	/**
	 * Returns the view type options (card, list, table).
	 *
	 * @return list of view types
	 */
	@Override
	public List<ViewTypeItem> getViewTypeItems() {

		PortletURL portletURL = getPortletURL();

		portletURL.setParameter(
			CommonConstants.PARAM_MVC_RENDER_COMMAND_NAME,
			CoursePortletConstants.COURSE_COMMAND_VIEW_COURSES);

		int delta =
			ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (delta > 0) {
			portletURL.setParameter(
				SearchContainer.DEFAULT_DELTA_PARAM, String.valueOf(delta));
		}

		String orderByCol = ParamUtil.getString(
			request, CommonConstants.PARAM_ORDER_BY_COL,
			CoursePortletConstants.COURSE_COLUMN_NAME);

		String orderByType = ParamUtil.getString(
			request, CommonConstants.PARAM_ORDER_BY_TYPE,
			CommonConstants.SORT_ASC);

		portletURL.setParameter(CommonConstants.PARAM_ORDER_BY_COL, orderByCol);
		portletURL.setParameter(
			CommonConstants.PARAM_ORDER_BY_TYPE, orderByType);

		int cur =
			ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM);

		if (cur > 0) {
			portletURL.setParameter(
				SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(cur));
		}

		return new ViewTypeItemList(portletURL, getDisplayStyle()) {

			{
				addCardViewTypeItem();

				addListViewTypeItem();

				addTableViewTypeItem();
			}
		};
	}

	/**
	 * Return the option items for the sort column menu.
	 *
	 * @return options list for the sort column menu
	 */
	@Override
	protected List<DropdownItem> getOrderByDropdownItems() {

		return new DropdownItemList() {

			{
				_addDropDownItem(
					this, CoursePortletConstants.COURSE_COLUMN_NAME);

				_addDropDownItem(this, CommonConstants.COLUMN_CREATE_DATE);
			}
		};
	}

	/**
	 * Add item to drop down item list
	 * @param dropdownItemList
	 * @param columnName
	 */
	private void _addDropDownItem(
		DropdownItemList dropdownItemList, String columnName) {

		dropdownItemList.add(dropdownItem -> {
			dropdownItem.setActive(columnName.equals(getOrderByCol()));
			try {

				dropdownItem.setHref(
					_getCurrentSortingURL(), CommonConstants.PARAM_ORDER_BY_COL,
					columnName);
			}
			catch (PortletException e) {

				e.printStackTrace();
			}

			dropdownItem.setLabel(LanguageUtil.get(request, columnName));
		});
	}

	/**
	 * Returns the current sorting URL.
	 *
	 * @return current sorting portlet URL
	 * @throws PortletException
	 */
	private PortletURL _getCurrentSortingURL()
		throws PortletException {

		PortletURL sortingURL =
			PortletURLUtil.clone(currentURLObj, liferayPortletResponse);

		sortingURL.setParameter(
			CommonConstants.PARAM_MVC_RENDER_COMMAND_NAME,
			CoursePortletConstants.COURSE_COMMAND_VIEW_COURSES);

		// Reset current page.

		sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");

		String keywords =
			ParamUtil.getString(request, CommonConstants.PARAM_KEYWORDS);

		if (Validator.isNotNull(keywords)) {
			sortingURL.setParameter(CommonConstants.PARAM_KEYWORDS, keywords);
		}

		return sortingURL;
	}

	private final PortalPreferences _portalPreferences;

}
