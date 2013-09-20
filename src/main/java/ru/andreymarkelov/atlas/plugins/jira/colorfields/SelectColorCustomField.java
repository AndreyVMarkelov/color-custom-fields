package ru.andreymarkelov.atlas.plugins.jira.colorfields;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.impl.SelectCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.manager.OptionsManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import com.atlassian.jira.issue.fields.rest.json.beans.JiraBaseUrls;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.Map;

public class SelectColorCustomField extends SelectCFType {
    public SelectColorCustomField(
            CustomFieldValuePersister customFieldValuePersister,
            OptionsManager optionsManager,
            GenericConfigManager genericConfigManager,
            JiraBaseUrls jiraBaseUrls) {
        super(customFieldValuePersister, optionsManager, genericConfigManager, jiraBaseUrls);
    }

    private String getColorString(Color color) {
        String rgb = Integer.toHexString(color.getRGB());
        rgb = rgb.substring(2, rgb.length());
        return "#".concat(rgb);
    }

    @Override
    public Map<String, Object> getVelocityParameters(final Issue issue, final CustomField field, final FieldLayoutItem fieldLayoutItem) {
        final Map<String, Object> map = super.getVelocityParameters(issue, field, fieldLayoutItem);

        if (issue == null) {
            return map;
        }

        Object color = issue.getCustomFieldValue(field);
        if (null != color) {
            try {
                Color c = Color.decode(color.toString());
                map.put("colorHex", getColorString(c));
            }
            catch (NumberFormatException nfe) {
                try {
                    Field colorField = Color.class.getField(color.toString().toLowerCase());
                    Color c = (Color) colorField.get(null);
                    map.put("colorHex", getColorString(c));
                } catch (Exception ce) {
                    map.put("colorHex", getColorString(Color.white));
                }
            }
        }
        return map;
    }
}
