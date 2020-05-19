package ru.andreymarkelov.atlas.plugins.jira.colorfields.field;

import com.atlassian.jira.config.ConstantsManager;
import com.atlassian.jira.issue.customfields.MultiSelectCustomFieldValueProvider;
import com.atlassian.jira.issue.customfields.manager.OptionsManager;
import com.atlassian.jira.issue.customfields.searchers.MultiSelectSearcher;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.fields.config.manager.FieldConfigSchemeManager;
import com.atlassian.jira.issue.fields.config.manager.IssueTypeSchemeManager;
import com.atlassian.jira.issue.search.searchers.renderer.SearchRenderer;
import com.atlassian.jira.jql.context.FieldConfigSchemeClauseContextUtil;
import com.atlassian.jira.jql.util.JqlSelectOptionsUtil;
import com.atlassian.jira.project.ProjectFactory;
import com.atlassian.jira.security.PermissionManager;
import com.atlassian.jira.util.JiraComponentFactory;
import com.atlassian.jira.util.JiraComponentLocator;
import com.atlassian.jira.web.FieldVisibilityManager;
import ru.andreymarkelov.atlas.plugins.jira.colorfields.service.ColorResolver;

public class ColorSelectSearcher extends MultiSelectSearcher {
    private volatile SearchRenderer searchRenderer;
    private FieldVisibilityManager fieldVisibilityManager;
    private JqlSelectOptionsUtil jqlSelectOptionsUtil;
    private final ColorResolver colorResolver;

    public ColorSelectSearcher(
            FieldVisibilityManager fieldVisibilityManager,
            OptionsManager optionsManager,
            FieldConfigSchemeManager fieldConfigSchemeManager,
            IssueTypeSchemeManager issueTypeSchemeManager,
            ConstantsManager constantsManager,
            PermissionManager permissionManager,
            ProjectFactory projectFactory,
            ColorResolver colorResolver) {
        super(new JiraComponentLocator(), JiraComponentFactory.getInstance());
        this.fieldVisibilityManager = fieldVisibilityManager;
        this.jqlSelectOptionsUtil = new JqlSelectOptionsUtil(
                optionsManager,
                fieldConfigSchemeManager,
                new FieldConfigSchemeClauseContextUtil(issueTypeSchemeManager, constantsManager, permissionManager, projectFactory));
        this.colorResolver = colorResolver;
    }

    public void init(final CustomField field) {
        super.init(field);
        searchRenderer = new ColorSelectSearchRender(
                field.getClauseNames(),
                getDescriptor(),
                field,
                new MultiSelectCustomFieldValueProvider(),
                fieldVisibilityManager,
                jqlSelectOptionsUtil,
                colorResolver
        );
    }

    public SearchRenderer getSearchRenderer() {
        return searchRenderer;
    }
}
