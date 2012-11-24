package ru.mail.jira.plugins.jira.customfields;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.customfields.converters.SelectConverter;
import com.atlassian.jira.issue.customfields.converters.StringConverter;
import com.atlassian.jira.issue.customfields.impl.SelectCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.manager.OptionsManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.layout.field.FieldLayoutItem;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.Map;

public class ColorCustomField
    extends SelectCFType
{
    /**
     * Constructor.
     */
    public ColorCustomField(
        CustomFieldValuePersister customFieldValuePersister,
        StringConverter stringConverter, SelectConverter selectConverter,
        OptionsManager optionsManager,
        GenericConfigManager genericConfigManager)
    {
        super(
            customFieldValuePersister,
            stringConverter,
            selectConverter,
            optionsManager,
            genericConfigManager);
    }

    private String getColorString(Color color)
    {
        String rgb = Integer.toHexString(color.getRGB());
        rgb = rgb.substring(2, rgb.length());
        return rgb;
    }

    @Override
    public Map<String, Object> getVelocityParameters(
        final Issue issue,
        final CustomField field,
        final FieldLayoutItem fieldLayoutItem)
    {
        final Map<String, Object> map = super.getVelocityParameters(issue, field, fieldLayoutItem);

        // This method is also called to get the default value, in
        // which case issue is null so we can't use it to add currencyLocale
        if (issue == null)
        {
            return map;
        }

        Object color = issue.getCustomFieldValue(field);
        if (null != color)
        {
            try
            {
                // get color by hex or octal value
                Color c = Color.decode(color.toString());
                map.put("colorHex", getColorString(c));
            }
            catch (NumberFormatException nfe)
            {
                // if we can't decode lets try to get it by name
                try
                {
                    // try to get a color by name using reflection
                    Field colorField = Color.class.getField(color.toString().toLowerCase());
                    Color c = (Color) colorField.get(null);
                    map.put("colorHex", getColorString(c));
                }
                catch (Exception ce)
                {
                    // if we can't get any color return white
                    map.put("colorHex", getColorString(Color.white));
                }
            }
        }

        return map;
    }
}
