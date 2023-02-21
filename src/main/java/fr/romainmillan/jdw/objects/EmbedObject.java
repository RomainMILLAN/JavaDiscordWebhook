package fr.romainmillan.jdw.objects;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.*;

public class EmbedObject {
    private String title;
    private String description;
    private String url;
    private Color color;
    private Footer footer;
    private Thumbnail thumbnail;
    private Image image;
    private Author author;
    private List<Field> fields = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Color getColor() {
        return color;
    }

    public Footer getFooter() {
        return footer;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public Image getImage() {
        return image;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Field> getFields() {
        return fields;
    }

    public EmbedObject setTitle(String title) {
        this.title = title;
        return this;
    }

    public EmbedObject setDescription(String description) {
        this.description = description;
        return this;
    }

    public EmbedObject setUrl(String url) {
        this.url = url;
        return this;
    }

    public EmbedObject setColor(Color color) {
        this.color = color;
        return this;
    }

    public EmbedObject setFooter(String text, String icon) {
        this.footer = new Footer(text, icon);
        return this;
    }

    public EmbedObject setThumbnail(String url) {
        this.thumbnail = new Thumbnail(url);
        return this;
    }

    public EmbedObject setImage(String url) {
        this.image = new Image(url);
        return this;
    }

    public EmbedObject setAuthor(String name, String url, String icon) {
        this.author = new Author(name, url, icon);
        return this;
    }

    public EmbedObject addField(String name, String value, boolean inline) {
        this.fields.add(new Field(name, value, inline));
        return this;
    }

    public static class Footer {
        private String text;
        private String iconUrl;

        private Footer(String text, String iconUrl) {
            this.text = text;
            this.iconUrl = iconUrl;
        }

        public String getText() {
            return text;
        }

        public String getIconUrl() {
            return iconUrl;
        }
    }

    public static class Thumbnail {
        private String url;

        private Thumbnail(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public static class Image {
        private String url;

        private Image(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    public static class Author {
        private String name;
        private String url;
        private String iconUrl;

        private Author(String name, String url, String iconUrl) {
            this.name = name;
            this.url = url;
            this.iconUrl = iconUrl;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        public String getIconUrl() {
            return iconUrl;
        }
    }

    public static class Field {
        private String name;
        private String value;
        private boolean inline;

        private Field(String name, String value, boolean inline) {
            this.name = name;
            this.value = value;
            this.inline = inline;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public boolean isInline() {
            return inline;
        }
    }

    public static class JSONObject {

        private final HashMap<String, Object> map = new HashMap<>();

        public void put(String key, Object value) {
            if (value != null) {
                map.put(key, value);
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            Set<Map.Entry<String, Object>> entrySet = map.entrySet();
            builder.append("{");

            int i = 0;
            for (Map.Entry<String, Object> entry : entrySet) {
                Object val = entry.getValue();
                builder.append(quote(entry.getKey())).append(":");

                if (val instanceof String) {
                    builder.append(quote(String.valueOf(val)));
                } else if (val instanceof Integer) {
                    builder.append(Integer.valueOf(String.valueOf(val)));
                } else if (val instanceof Boolean) {
                    builder.append(val);
                } else if (val instanceof JSONObject) {
                    builder.append(val.toString());
                } else if (val.getClass().isArray()) {
                    builder.append("[");
                    int len = Array.getLength(val);
                    for (int j = 0; j < len; j++) {
                        builder.append(Array.get(val, j).toString()).append(j != len - 1 ? "," : "");
                    }
                    builder.append("]");
                }

                builder.append(++i == entrySet.size() ? "}" : ",");
            }

            return builder.toString();
        }

        private String quote(String string) {
            return "\"" + string + "\"";
        }
    }

    /**
     *
     * Copyright (C) 2023 by Romain MILLAN, all rights reserved
     * All codes are selfmade
     * Copy and paste from https://github.com/Wabez3ter/JavaDiscordWebhook are allowed only if you mention me
     *
     */
}