package io.swagger.v3.core.util;

import com.fasterxml.jackson.databind.type.TypeFactory;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.BooleanSchema;
import io.swagger.v3.oas.models.media.ByteArraySchema;
import io.swagger.v3.oas.models.media.DateSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.JsonSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.media.UUIDSchema;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The <code>PrimitiveType</code> enumeration defines a mapping of limited set
 * of classes into Swagger primitive types.
 */
public enum PrimitiveType {

    STRING(String.class, "string") {
        @Override
        public Schema createProperty() {
            return new StringSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string");
        }
    },
    BOOLEAN(Boolean.class, "boolean") {
        @Override
        public Schema createProperty() {
            return new BooleanSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("boolean");
        }
    },
    BYTE(Byte.class, "byte") {
        @Override
        public Schema createProperty() {
            if (
                    (System.getProperty(Schema.BINARY_STRING_CONVERSION_PROPERTY) != null && System.getProperty(Schema.BINARY_STRING_CONVERSION_PROPERTY).equals(Schema.BynaryStringConversion.BINARY_STRING_CONVERSION_STRING_SCHEMA.toString())) ||
                    (System.getenv(Schema.BINARY_STRING_CONVERSION_PROPERTY) != null && System.getenv(Schema.BINARY_STRING_CONVERSION_PROPERTY).equals(Schema.BynaryStringConversion.BINARY_STRING_CONVERSION_STRING_SCHEMA.toString()))) {
                return new StringSchema().format("byte");
            }
            return new ByteArraySchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("byte");
        }
    },
    BINARY(Byte.class, "binary") {
        @Override
        public Schema createProperty() {
            if (
                    (System.getProperty(Schema.BINARY_STRING_CONVERSION_PROPERTY) != null && System.getProperty(Schema.BINARY_STRING_CONVERSION_PROPERTY).equals(Schema.BynaryStringConversion.BINARY_STRING_CONVERSION_STRING_SCHEMA.toString())) ||
                    (System.getenv(Schema.BINARY_STRING_CONVERSION_PROPERTY) != null && System.getenv(Schema.BINARY_STRING_CONVERSION_PROPERTY).equals(Schema.BynaryStringConversion.BINARY_STRING_CONVERSION_STRING_SCHEMA.toString()))) {
                return new StringSchema().format("binary");
            }
            return new BinarySchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("binary");
        }
    },
    URI(java.net.URI.class, "uri") {
        @Override
        public Schema createProperty() {
            return new StringSchema().format("uri");
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("uri");
        }
    },
    URL(java.net.URL.class, "url") {
        @Override
        public Schema createProperty() {
            return new StringSchema().format("url");
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("url");
        }
    },
    EMAIL(String.class, "email") {
        @Override
        public Schema createProperty() {
            return new StringSchema().format("email");
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("email");
        }
    },
    UUID(java.util.UUID.class, "uuid") {
        @Override
        public UUIDSchema createProperty() {
            return new UUIDSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("uuid");
        }
    },
    INT(Integer.class, "integer") {
        @Override
        public IntegerSchema createProperty() {
            return new IntegerSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("integer").format("int32");
        }
    },
    LONG(Long.class, "long") {
        @Override
        public Schema createProperty() {
            return new IntegerSchema().format("int64");
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("integer").format("int64");
        }
    },
    FLOAT(Float.class, "float") {
        @Override
        public Schema createProperty() {
            return new NumberSchema().format("float");
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("number").format("float");
        }
    },
    DOUBLE(Double.class, "double") {
        @Override
        public Schema createProperty() {
            return new NumberSchema().format("double");
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("number").format("double");
        }
    },
    INTEGER(java.math.BigInteger.class) {
        @Override
        public Schema createProperty() {
            return new IntegerSchema().format(null);
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("integer");
        }
    },
    DECIMAL(java.math.BigDecimal.class, "number") {
        @Override
        public Schema createProperty() {
            return new NumberSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("number");
        }
    },
    NUMBER(Number.class, "number") {
        @Override
        public Schema createProperty() {
            return new NumberSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("number");
        }
    },
    DATE(DateStub.class, "date") {
        @Override
        public DateSchema createProperty() {
            return new DateSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("date");
        }
    },
    DATE_TIME(java.util.Date.class, "date-time") {
        @Override
        public DateTimeSchema createProperty() {
            return new DateTimeSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("date-time");
        }
    },
    PARTIAL_TIME(java.time.LocalTime.class, "partial-time") {
        @Override
        public Schema createProperty() {
            return new StringSchema().format("partial-time");
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("partial-time");
        }
    },
    FILE(java.io.File.class, "file") {
        @Override
        public FileSchema createProperty() {
            return new FileSchema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema().typesItem("string").format("binary");
        }
    },
    OBJECT(Object.class) {

        @Override
        public Schema createProperty() {
            return explicitObjectType == null || explicitObjectType ? new Schema().type("object"): new Schema();
        }
        @Override
        public Schema createProperty31() {
            return new JsonSchema();
        }
    };

    public static Boolean explicitObjectType;
    private static final Map<Class<?>, PrimitiveType> KEY_CLASSES;
    private static final Map<Class<?>, Collection<PrimitiveType>> MULTI_KEY_CLASSES;
    private static final Map<Class<?>, PrimitiveType> BASE_CLASSES;
    /**
     * Adds support of a small number of "well-known" types, specifically for
     * Joda lib.
     */
    private static final Map<String, PrimitiveType> EXTERNAL_CLASSES;

    /**
     * Allows to exclude specific classes from KEY_CLASSES mappings to primitive
     *
     */
    private static Set<String> customExcludedClasses = ConcurrentHashMap.newKeySet();

    /**
     * Allows to exclude specific classes from EXTERNAL_CLASSES mappings to primitive
     *
     */
    private static Set<String> customExcludedExternalClasses = ConcurrentHashMap.newKeySet();


    /**
     * Adds support for custom mapping of classes to primitive types
     */
    private static Map<String, PrimitiveType> customClasses = new ConcurrentHashMap<>();

    /**
     * class qualified names prefixes to be considered as "system" types
     */
    private static Set<String> systemPrefixes = ConcurrentHashMap.newKeySet();
    /**
     * class qualified names NOT to be considered as "system" types
     */
    private static Set<String> nonSystemTypes = ConcurrentHashMap.newKeySet();
    /**
     * package names NOT to be considered as "system" types
     */
    private static Set<String> nonSystemTypePackages = ConcurrentHashMap.newKeySet();

    /**
     * Alternative names for primitive types that have to be supported for
     * backward compatibility.
     */
    private static final Map<String, PrimitiveType> NAMES;
    private final Class<?> keyClass;
    private final String commonName;

    public static final Map<String, String> datatypeMappings;

    static {
        systemPrefixes.add("java.");
        systemPrefixes.add("javax.");
        nonSystemTypes.add("java.time.LocalTime");

        final Map<String, String> dms = new HashMap<>();
        dms.put("integer_int32", "integer");
        dms.put("integer_", "integer");
        dms.put("integer_int64", "long");
        dms.put("number_", "number");
        dms.put("number_float", "float");
        dms.put("number_double", "double");
        dms.put("string_", "string");
        dms.put("string_byte", "byte");
        dms.put("string_email", "email");
        dms.put("string_binary", "binary");
        dms.put("string_uri", "uri");
        dms.put("string_url", "url");
        dms.put("string_uuid", "uuid");
        dms.put("string_date", "date");
        dms.put("string_date-time", "date-time");
        dms.put("string_partial-time", "partial-time");
        dms.put("string_password", "password");
        dms.put("boolean_", "boolean");
        dms.put("object_", "object");
        datatypeMappings = Collections.unmodifiableMap(dms);

        final Map<Class<?>, PrimitiveType> keyClasses = new HashMap<>();
        addKeys(keyClasses, BOOLEAN, Boolean.class, Boolean.TYPE);
        addKeys(keyClasses, STRING, String.class, Character.class, Character.TYPE);
        addKeys(keyClasses, BYTE, Byte.class, Byte.TYPE);
        addKeys(keyClasses, URL, java.net.URL.class);
        addKeys(keyClasses, URI, java.net.URI.class);
        addKeys(keyClasses, UUID, java.util.UUID.class);
        addKeys(keyClasses, INT, Integer.class, Integer.TYPE, Short.class, Short.TYPE);
        addKeys(keyClasses, LONG, Long.class, Long.TYPE);
        addKeys(keyClasses, FLOAT, Float.class, Float.TYPE);
        addKeys(keyClasses, DOUBLE, Double.class, Double.TYPE);
        addKeys(keyClasses, INTEGER, java.math.BigInteger.class);
        addKeys(keyClasses, DECIMAL, java.math.BigDecimal.class);
        addKeys(keyClasses, NUMBER, Number.class);
        addKeys(keyClasses, DATE, DateStub.class);
        addKeys(keyClasses, DATE_TIME, java.util.Date.class);
        addKeys(keyClasses, FILE, java.io.File.class);
        addKeys(keyClasses, OBJECT, Object.class);
        KEY_CLASSES = Collections.unmodifiableMap(keyClasses);

        final Map<Class<?>, Collection<PrimitiveType>> multiKeyClasses = new HashMap<>();
        addMultiKeys(multiKeyClasses, BYTE, byte[].class);
        addMultiKeys(multiKeyClasses, BINARY, byte[].class);
        MULTI_KEY_CLASSES = Collections.unmodifiableMap(multiKeyClasses);

        final Map<Class<?>, PrimitiveType> baseClasses = new HashMap<>();
        addKeys(baseClasses, DATE_TIME, java.util.Date.class, java.util.Calendar.class);
        BASE_CLASSES = Collections.unmodifiableMap(baseClasses);

        final Map<String, PrimitiveType> externalClasses = new HashMap<>();
        addKeys(externalClasses, DATE, "org.joda.time.LocalDate", "java.time.LocalDate");
        addKeys(externalClasses, DATE_TIME,
                "java.time.LocalDateTime",
                "java.time.ZonedDateTime",
                "java.time.OffsetDateTime",
                "javax.xml.datatype.XMLGregorianCalendar",
                "org.joda.time.LocalDateTime",
                "org.joda.time.ReadableDateTime",
                "org.joda.time.DateTime",
                "java.time.Instant");
        EXTERNAL_CLASSES = Collections.unmodifiableMap(externalClasses);

        final Map<String, PrimitiveType> names = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (PrimitiveType item : values()) {
            final String name = item.getCommonName();
            if (name != null) {
                addKeys(names, item, name);
            }
        }
        addKeys(names, INT, "int");
        addKeys(names, OBJECT, "object");
        NAMES = Collections.unmodifiableMap(names);

        if (System.getenv(Schema.EXPLICIT_OBJECT_SCHEMA_PROPERTY) != null) {
            explicitObjectType = Boolean.parseBoolean(System.getenv(Schema.EXPLICIT_OBJECT_SCHEMA_PROPERTY));
        } else if (System.getProperty(Schema.EXPLICIT_OBJECT_SCHEMA_PROPERTY) != null) {
            explicitObjectType = Boolean.parseBoolean(System.getProperty(Schema.EXPLICIT_OBJECT_SCHEMA_PROPERTY));
        }
    }

    private PrimitiveType(Class<?> keyClass) {
        this(keyClass, null);
    }

    private PrimitiveType(Class<?> keyClass, String commonName) {
        this.keyClass = keyClass;
        this.commonName = commonName;
    }


    /**
     * Adds support for custom mapping of classes to primitive types
     *
     * @return Map of custom classes to primitive type
     * @since 2.0.6
     */
    public static Set<String> customExcludedClasses() {
        return customExcludedClasses;
    }

    /**
     * Adds support for custom mapping of classes to primitive types
     *
     * @return Map of custom classes to primitive type
     * @since 2.1.2
     */
    public static Set<String> customExcludedExternalClasses() {
        return customExcludedExternalClasses;
    }

    /**
     * Adds support for custom mapping of classes to primitive types
     *
     * @return Map of custom classes to primitive type
     * @since 2.0.6
     */
    public static Map<String, PrimitiveType> customClasses() {
        return customClasses;
    }

    /**
     * class qualified names prefixes to be considered as "system" types
     *
     * @return Mutable set of class qualified names prefixes to be considered as "system" types
     * @since 2.0.6
     */
    public static Set<String> systemPrefixes() {
        return systemPrefixes;
    }

    /**
     * class qualified names NOT to be considered as "system" types
     *
     * @return Mutable set of class qualified names NOT to be considered as "system" types
     * @since 2.0.6
     */
    public static Set<String> nonSystemTypes() {
        return nonSystemTypes;
    }

    /**
     * package names NOT to be considered as "system" types
     *
     * @return Mutable set of package names NOT to be considered as "system" types
     * @since 2.0.6
     */
    public static Set<String> nonSystemTypePackages() {
        return nonSystemTypePackages;
    }

    public static PrimitiveType fromTypeAndFormat(Type type, String format) {
        final Class<?> raw = TypeFactory.defaultInstance().constructType(type).getRawClass();
        final Collection<PrimitiveType> keys = MULTI_KEY_CLASSES.get(raw);
        if (keys == null || keys.isEmpty() || StringUtils.isBlank(format)) {
            return fromType(type);
        } else {
            return keys
                .stream()
                .filter(t -> t.getCommonName().equalsIgnoreCase(format))
                .findAny()
                .orElse(null);
        }
    }
    
    public static PrimitiveType fromType(Type type) {
        final Class<?> raw = TypeFactory.defaultInstance().constructType(type).getRawClass();
        final PrimitiveType key = KEY_CLASSES.get(raw);
        if (key != null) {
            if (!customExcludedClasses.contains(raw.getName())) {
                return key;
            }
        }
        
        final Collection<PrimitiveType> keys = MULTI_KEY_CLASSES.get(raw);
        if (keys != null && !keys.isEmpty()) {
            final PrimitiveType first = keys.iterator().next();
            if (!customExcludedClasses.contains(raw.getName())) {
                return first;
            }
        }

        final PrimitiveType custom = customClasses.get(raw.getName());
        if (custom != null) {
            return custom;
        }

        final PrimitiveType external = EXTERNAL_CLASSES.get(raw.getName());
        if (external != null) {
            if (!customExcludedExternalClasses().contains(raw.getName())) {
                return external;
            }

        }

        for (Map.Entry<Class<?>, PrimitiveType> entry : BASE_CLASSES.entrySet()) {
            if (entry.getKey().isAssignableFrom(raw)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static PrimitiveType fromName(String name) {
        if (name == null) {
            return null;
        }
        PrimitiveType fromName = NAMES.get(name);
        if (fromName == null) {
            if (!customExcludedExternalClasses().contains(name)) {
                fromName = EXTERNAL_CLASSES.get(name);
            }
        }
        return fromName;
    }

    public static PrimitiveType fromTypeAndFormat(String type, String format) {
        if (StringUtils.isNotBlank(type) && type.equals("object")) {
            return null;
        }
        return fromName(datatypeMappings.get(String.format("%s_%s", StringUtils.isBlank(type) ? "" : type, StringUtils.isBlank(format) ? "" : format)));
    }

    public static Schema createProperty(Type type) {
        return createProperty(type, false);
    }

    public static Schema createProperty(Type type, boolean openapi31) {
        final PrimitiveType item = fromType(type);
        return item == null ? null : openapi31 ? item.createProperty31() : item.createProperty();
    }

    public static Schema createProperty(String name) {
        return createProperty(name, false);
    }

    public static Schema createProperty(String name, boolean openapi31) {
        final PrimitiveType item = fromName(name);
        return item == null ? null : openapi31 ? item.createProperty31() : item.createProperty();
    }

    public static String getCommonName(Type type) {
        final PrimitiveType item = fromType(type);
        return item == null ? null : item.getCommonName();
    }

    public Class<?> getKeyClass() {
        return keyClass;
    }

    public String getCommonName() {
        return commonName;
    }

    public abstract Schema createProperty();
    public abstract Schema createProperty31();

    private static <K> void addKeys(Map<K, PrimitiveType> map, PrimitiveType type, K... keys) {
        for (K key : keys) {
            map.put(key, type);
        }
    }

    private static <K> void addMultiKeys(Map<K, Collection<PrimitiveType>> map, PrimitiveType type, K... keys) {
        for (K key : keys) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(type);
        }
    }

    private static class DateStub {
        private DateStub() {
        }
    }

    /**
     * Convenience method to map LocalTime to string primitive with rfc3339 format partial-time.
     * See https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html#anchor14
     *
     * @since 2.0.6
     */
    public static void enablePartialTime() {
        customClasses().put("org.joda.time.LocalTime", PrimitiveType.PARTIAL_TIME);
        customClasses().put("java.time.LocalTime", PrimitiveType.PARTIAL_TIME);
    }
}
