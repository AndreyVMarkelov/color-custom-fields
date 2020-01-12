package ru.andreymarkelov.atlas.plugins.jira.colorfields.service;

/**
 * Convert user entered color to HEX.
 */
public interface ColorResolver {
    String resolveColor(String userColor);
}
