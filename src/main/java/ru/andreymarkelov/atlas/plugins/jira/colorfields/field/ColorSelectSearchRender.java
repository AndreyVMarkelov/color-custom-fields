package ru.andreymarkelov.atlas.plugins.jira.colorfields.field;

import com.atlassian.jira.issue.customfields.CustomFieldValueProvider;
import com.atlassian.jira.issue.customfields.searchers.renderer.MultiSelectCustomFieldSearchRenderer;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.search.ClauseNames;
import com.atlassian.jira.issue.search.SearchContext;
import com.atlassian.jira.issue.transport.FieldValuesHolder;
import com.atlassian.jira.jql.util.JqlSelectOptionsUtil;
import com.atlassian.jira.plugin.customfield.CustomFieldSearcherModuleDescriptor;
import com.atlassian.jira.web.FieldVisibilityManager;
import ru.andreymarkelov.atlas.plugins.jira.colorfields.service.ColorResolver;
import webwork.action.Action;

import java.util.Map;

public class ColorSelectSearchRender extends MultiSelectCustomFieldSearchRenderer {
    private final ColorResolver colorResolver;

    public ColorSelectSearchRender(
            ClauseNames clauseNames,
            CustomFieldSearcherModuleDescriptor customFieldSearcherModuleDescriptor,
            CustomField customField,
            CustomFieldValueProvider customFieldValueProvider,
            FieldVisibilityManager fieldVisibilityManager,
            JqlSelectOptionsUtil jqlSelectOptionsUtil,
            ColorResolver colorResolver) {
        super(clauseNames, customFieldSearcherModuleDescriptor, customField, customFieldValueProvider, fieldVisibilityManager, jqlSelectOptionsUtil);
        this.colorResolver = colorResolver;
    }

    public String getEditHtml(
            SearchContext searchContext,
            FieldValuesHolder fieldValuesHolder,
            Map<?, ?> displayParameters,
            Action action,
            Map<String, Object> velocityParams) {
        velocityParams.put("colorResolver", colorResolver);
        return super.getEditHtml(searchContext, fieldValuesHolder, displayParameters, action, velocityParams);
    }

    public String getViewHtml(
            SearchContext searchContext,
            FieldValuesHolder fieldValuesHolder,
            Map<?, ?> displayParameters,
            Action action,
            Map<String, Object> velocityParams) {
        velocityParams.put("colorResolver", colorResolver);
        return super.getViewHtml(searchContext, fieldValuesHolder, displayParameters, action, velocityParams);
    }
}
