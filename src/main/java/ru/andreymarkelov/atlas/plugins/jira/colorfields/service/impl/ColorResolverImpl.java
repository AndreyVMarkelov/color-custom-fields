package ru.andreymarkelov.atlas.plugins.jira.colorfields.service.impl;

import ru.andreymarkelov.atlas.plugins.jira.colorfields.service.ColorResolver;

public class ColorResolverImpl implements ColorResolver {
    @Override
    public String resolveColor(String userColor) {
        return ru.andreymarkelov.atlas.plugins.jira.util.ColorResolver.getHexColor(userColor);
    }
}
