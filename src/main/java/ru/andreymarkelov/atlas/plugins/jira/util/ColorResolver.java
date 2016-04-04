package ru.andreymarkelov.atlas.plugins.jira.util;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.util.StringUtils;

public class ColorResolver {
    private static final Map<String, String> supportedColors = new HashMap<>();
    static {
        supportedColors.put("pink", "#FFC0CB");
        supportedColors.put("lightpink", "#FFB6C1");
        supportedColors.put("hotpink", "#FF69B4");
        supportedColors.put("deeppink", "#FF1493");
        supportedColors.put("palevioletred", "#DB7093");
        supportedColors.put("mediumvioletred", "#C71585");
        supportedColors.put("lightsalmon", "#FFA07A");
        supportedColors.put("salmon", "#FA8072");
        supportedColors.put("darksalmon", "#E9967A");
        supportedColors.put("lightcoral", "#F08080");
        supportedColors.put("indianred", "#CD5C5C");
        supportedColors.put("crimson", "#DC143C");
        supportedColors.put("firebrick", "#B22222");
        supportedColors.put("darkred", "#8B0000");
        supportedColors.put("red", "#FF0000");
        supportedColors.put("orangered", "#FF4500");
        supportedColors.put("tomato", "#FF6347");
        supportedColors.put("coral", "#FF7F50");
        supportedColors.put("darkorange", "#FF8C00");
        supportedColors.put("orange", "#FFA500");
        supportedColors.put("yellow", "#FFFF00");
        supportedColors.put("lightyellow", "#FFFFE0");
        supportedColors.put("lemonchiffon", "#FFFACD");
        supportedColors.put("lightgoldenrodyellow", "#FAFAD2");
        supportedColors.put("papayawhip", "#FFEFD5");
        supportedColors.put("moccasin", "#FFE4B5");
        supportedColors.put("peachpuff", "#FFDAB9");
        supportedColors.put("palegoldenrod", "#EEE8AA");
        supportedColors.put("khaki", "#F0E68C");
        supportedColors.put("darkkhaki", "#BDB76B");
        supportedColors.put("gold", "#FFD700");
        supportedColors.put("cornsilk", "#FFF8DC");
        supportedColors.put("blanchedalmond", "#FFEBCD");
        supportedColors.put("bisque", "#FFE4C4");
        supportedColors.put("navajowhite", "#FFDEAD");
        supportedColors.put("wheat", "#F5DEB3");
        supportedColors.put("burlywood", "#DEB887");
        supportedColors.put("tan", "#D2B48C");
        supportedColors.put("rosybrown", "#BC8F8F");
        supportedColors.put("sandybrown", "#F4A460");
        supportedColors.put("goldenrod", "#DAA520");
        supportedColors.put("darkgoldenrod", "#B8860B");
        supportedColors.put("peru", "#CD853F");
        supportedColors.put("chocolate", "#D2691E");
        supportedColors.put("saddlebrown", "#8B4513");
        supportedColors.put("sienna", "#A0522D");
        supportedColors.put("brown", "#A52A2A");
        supportedColors.put("maroon", "#800000");
        supportedColors.put("darkolivegreen", "#556B2F");
        supportedColors.put("olive", "#808000");
        supportedColors.put("olivedrab", "#6B8E23");
        supportedColors.put("yellowgreen", "#9ACD32");
        supportedColors.put("limegreen", "#32CD32");
        supportedColors.put("lime", "#00FF00");
        supportedColors.put("lawngreen", "#7CFC00");
        supportedColors.put("chartreuse", "#7FFF00");
        supportedColors.put("greenyellow", "#ADFF2F");
        supportedColors.put("springgreen", "#00FF7F");
        supportedColors.put("mediumspringgreen", "#00FA9A");
        supportedColors.put("lightgreen", "#90EE90");
        supportedColors.put("palegreen", "#98FB98");
        supportedColors.put("darkseagreen", "#8FBC8F");
        supportedColors.put("mediumaquamarine", "#66CDAA");
        supportedColors.put("mediumgeagreen", "#3CB371");
        supportedColors.put("seagreen", "#2E8B57");
        supportedColors.put("forestgreen", "#228B22");
        supportedColors.put("green", "#008000");
        supportedColors.put("darkgreen", "#006400");
        supportedColors.put("aqua", "#00FFFF");
        supportedColors.put("cyan", "#00FFFF");
        supportedColors.put("lightcyan", "#E0FFFF");
        supportedColors.put("paleturquoise", "#AFEEEE");
        supportedColors.put("aquamarine", "#7FFFD4");
        supportedColors.put("turquoise", "#40E0D0");
        supportedColors.put("mediumturquoise", "#48D1CC");
        supportedColors.put("darkturquoise", "#00CED1");
        supportedColors.put("lightseagreen", "#20B2AA");
        supportedColors.put("cadetblue", "#5F9EA0");
        supportedColors.put("darkcyan", "#008B8B");
        supportedColors.put("teal", "#008080");
        supportedColors.put("lightsteelblue", "#B0C4DE");
        supportedColors.put("powderblue", "#B0E0E6");
        supportedColors.put("lightblue", "#ADD8E6");
        supportedColors.put("skyblue", "#87CEEB");
        supportedColors.put("lightskyblue", "#87CEFA");
        supportedColors.put("deepskyblue", "#00BFFF");
        supportedColors.put("dodgerblue", "#1E90FF");
        supportedColors.put("cornflowerblue", "#6495ED");
        supportedColors.put("steelblue", "#4682B4");
        supportedColors.put("royalblue", "#4169E1");
        supportedColors.put("blue", "#0000FF");
        supportedColors.put("mediumblue", "#0000CD");
        supportedColors.put("darkblue", "#00008B");
        supportedColors.put("navy", "#000080");
        supportedColors.put("midnightblue", "#191970");
        supportedColors.put("lavender", "#E6E6FA");
        supportedColors.put("thistle", "#D8BFD8");
        supportedColors.put("plum", "#DDA0DD");
        supportedColors.put("violet", "#EE82EE");
        supportedColors.put("orchid", "#DA70D6");
        supportedColors.put("fuchsia", "#FF00FF");
        supportedColors.put("magenta", "#FF00FF");
        supportedColors.put("mediumorchid", "#BA55D3");
        supportedColors.put("mediumpurple", "#9370DB");
        supportedColors.put("blueviolet", "#8A2BE2");
        supportedColors.put("darkviolet", "#9400D3");
        supportedColors.put("darkorchid", "#9932CC");
        supportedColors.put("darkmagenta", "#8B008B");
        supportedColors.put("purple", "#800080");
        supportedColors.put("indigo", "#4B0082");
        supportedColors.put("darkslateblue", "#483D8B");
        supportedColors.put("slateblue", "#6A5ACD");
        supportedColors.put("mediumslateblue", "#7B68EE");
        supportedColors.put("white", "#FFFFFF");
        supportedColors.put("snow", "#FFFAFA");
        supportedColors.put("honeydew", "#F0FFF0");
        supportedColors.put("mintcream", "#F5FFFA");
        supportedColors.put("azure", "#F0FFFF");
        supportedColors.put("aliceblue", "#F0F8FF");
        supportedColors.put("ghostwhite", "#F8F8FF");
        supportedColors.put("whitesmoke", "#F5F5F5");
        supportedColors.put("seashell", "#FFF5EE");
        supportedColors.put("beige", "#F5F5DC");
        supportedColors.put("oldlace", "#FDF5E6");
        supportedColors.put("floralwhite", "#FFFAF0");
        supportedColors.put("ivory", "#FFFFF0");
        supportedColors.put("antiquewhite", "#FAEBD7");
        supportedColors.put("linen", "#FAF0E6");
        supportedColors.put("lavenderblush", "#FFF0F5");
        supportedColors.put("mistyrose", "#FFE4E1");
        supportedColors.put("gainsboro", "#DCDCDC");
        supportedColors.put("lightgrey", "#D3D3D3");
        supportedColors.put("silver", "#C0C0C0");
        supportedColors.put("lightgray", "#C0C0C0");
        supportedColors.put("darkgray", "#A9A9A9");
        supportedColors.put("gray", "#808080");
        supportedColors.put("dimgray", "#696969");
        supportedColors.put("lightslategray", "#778899");
        supportedColors.put("slategray", "#708090");
        supportedColors.put("darkslategray", "#2F4F4F");
        supportedColors.put("black", "#000000");
    }

    public String getHexColor(String color) {
        if (Objects.isNull(color)) {
            return null;
        }

        String colorKey = StringUtils.trimAllWhitespace(color).toLowerCase();
        if (supportedColors.containsKey(colorKey)) {
            return supportedColors.get(colorKey);
        }

        try {
            return getColorString(Color.decode(color));
        } catch (NumberFormatException nfe) {
            return getColorString(Color.white);
        }
    }

    private String getColorString(Color color) {
        String rgb = Integer.toHexString(color.getRGB());
        rgb = rgb.substring(2, rgb.length());
        return "#".concat(rgb);
    }
}
