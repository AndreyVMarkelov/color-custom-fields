package ru.andreymarkelov.atlas.plugins.jira.colorfields;

import com.atlassian.jira.issue.customfields.impl.GenericTextCFType;
import com.atlassian.jira.issue.customfields.manager.GenericConfigManager;
import com.atlassian.jira.issue.customfields.persistence.CustomFieldValuePersister;
import com.atlassian.jira.issue.fields.TextFieldCharacterLengthValidator;
import com.atlassian.jira.security.JiraAuthenticationContext;

public class ColorPickerField extends GenericTextCFType {
    public ColorPickerField(
            CustomFieldValuePersister customFieldValuePersister,
            GenericConfigManager genericConfigManager,
            TextFieldCharacterLengthValidator textFieldCharacterLengthValidator,
            JiraAuthenticationContext jiraAuthenticationContext) {
        super(customFieldValuePersister, genericConfigManager, textFieldCharacterLengthValidator, jiraAuthenticationContext);
    }
}
