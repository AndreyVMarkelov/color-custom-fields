package ru.andreymarkelov.atlas.plugins.jira.colorfields;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.SelectCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.manager.OptionsManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.atlassian.jira.issue.fields.rest.json.beans.JiraBaseUrls;
import ru.andreymarkelov.atlas.plugins.jira.colorfields.service.ColorResolver;

import java.util.Map;

public class SelectColorCustomField extends SelectCFType {
    private final ColorResolver colorResolver;

    public SelectColorCustomField(
            CustomFieldValuePersister customFieldValuePersister,
            OptionsManager optionsManager,
            GenericConfigManager genericConfigManager,
            JiraBaseUrls jiraBaseUrls,
            ColorResolver colorResolver) {
        super(customFieldValuePersister, optionsManager, genericConfigManager, jiraBaseUrls);
        this.colorResolver = colorResolver;
    }

    @Override
    public Map<String, Object> getVelocityParameters(final Issue issue, final CustomField customField, final FieldLayoutItem fieldLayoutItem) {
        final Map<String, Object> map = super.getVelocityParameters(issue, customField, fieldLayoutItem);
        map.put("colorResolver", colorResolver);

        if (issue == null) {
            return map;
        }

        Object color = issue.getCustomFieldValue(customField);
        if (color != null) {
            map.put("colorHex", colorResolver.resolveColor(color.toString()));
        }
        return map;
    }
}
