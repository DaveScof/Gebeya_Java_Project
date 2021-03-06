package com.gebeya.training.java.db;

import com.gebeya.training.java.base.Base;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by mativo on 26/11/2016.
 */
public class ContentValues extends Base {
    private HashMap<String, Object> mValues;

    public ContentValues() {
        mValues = new HashMap<>();
    }

    /**
     * Creates a set of values copied from the given HashMap.
     *
     * @param values the values to start with
     * {@hide}
     */
    private ContentValues(HashMap<String, Object> values) {
        mValues = values;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ContentValues)) {
            return false;
        }
        return mValues.equals(((ContentValues) object).mValues);
    }

    @Override
    public int hashCode() {
        return mValues.hashCode();
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, String value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds all values from the passed in ContentValues.
     *
     * @param other the ContentValues from which to copy
     */
    public ContentValues putAll(ContentValues other) {
        mValues.putAll(other.mValues);
        return this;
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, Byte value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, Short value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, Integer value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, Long value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, Float value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, Double value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, Boolean value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds a value to the set.
     *
     * @param key the name of the value to put
     * @param value the data for the value to put
     */
    public ContentValues put(String key, byte[] value) {
        mValues.put(key, value);
        return this;
    }

    /**
     * Adds a null value to the set.
     *
     * @param key the name of the value to make null
     */
    public ContentValues putNull(String key) {
        mValues.put(key, null);
        return this;
    }

    /**
     * Returns the number of values.
     *
     * @return the number of values
     */
    public int size() {
        return mValues.size();
    }

    /**
     * Remove a single value.
     *
     * @param key the name of the value to remove
     */
    public void remove(String key) {
        mValues.remove(key);
    }

    /**
     * Removes all values.
     */
    public void clear() {
        mValues.clear();
    }

    /**
     * Returns true if this object has the named value.
     *
     * @param key the value to check for
     * @return {@code true} if the value is present, {@code false} otherwise
     */
    public boolean containsKey(String key) {
        return mValues.containsKey(key);
    }

    /**
     * Gets a value. Valid value types are {@link String}, {@link Boolean},
     * {@link Number}, and {@code byte[]} implementations.
     *
     * @param key the value to get
     * @return the data for the value, or {@code null} if the value is missing or if {@code null}
     *         was previously added with the given {@code key}
     */
    public Object get(String key) {
        return mValues.get(key);
    }

    /**
     * Gets a value and converts it to a String.
     *
     * @param key the value to get
     * @return the String for the value
     */
    public String getAsString(String key) {
        Object value = mValues.get(key);
        return value != null ? value.toString() : null;
    }

    /**
     * Gets a value and converts it to a Long.
     *
     * @param key the value to get
     * @return the Long value, or {@code null} if the value is missing or cannot be converted
     */
    public Long getAsLong(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).longValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Long.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    println("Cannot parse Long value for " + value + " at key " + key);
                    return null;
                }
            } else {
                println("Cannot cast value for " + key + " to a Long: " + value);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to an Integer.
     *
     * @param key the value to get
     * @return the Integer value, or {@code null} if the value is missing or cannot be converted
     */
    public Integer getAsInteger(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).intValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Integer.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    println("Cannot parse Integer value for " + value + " at key " + key);
                    return null;
                }
            } else {
                println("Cannot cast value for " + key + " to a Integer: " + value);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Short.
     *
     * @param key the value to get
     * @return the Short value, or {@code null} if the value is missing or cannot be converted
     */
    public Short getAsShort(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).shortValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Short.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    println("Cannot parse Short value for " + value + " at key " + key);
                    return null;
                }
            } else {
                println("Cannot cast value for " + key + " to a Short: " + value);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Byte.
     *
     * @param key the value to get
     * @return the Byte value, or {@code null} if the value is missing or cannot be converted
     */
    public Byte getAsByte(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).byteValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Byte.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    println("Cannot parse Byte value for " + value + " at key " + key);
                    return null;
                }
            } else {
                println("Cannot cast value for " + key + " to a Byte: " + value);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Double.
     *
     * @param key the value to get
     * @return the Double value, or {@code null} if the value is missing or cannot be converted
     */
    public Double getAsDouble(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).doubleValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Double.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    println("Cannot parse Double value for " + value + " at key " + key);
                    return null;
                }
            } else {
                println("Cannot cast value for " + key + " to a Double: " + value);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Float.
     *
     * @param key the value to get
     * @return the Float value, or {@code null} if the value is missing or cannot be converted
     */
    public Float getAsFloat(String key) {
        Object value = mValues.get(key);
        try {
            return value != null ? ((Number) value).floatValue() : null;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                try {
                    return Float.valueOf(value.toString());
                } catch (NumberFormatException e2) {
                    println("Cannot parse Float value for " + value + " at key " + key);
                    return null;
                }
            } else {
                println("Cannot cast value for " + key + " to a Float: " + value);
                return null;
            }
        }
    }

    /**
     * Gets a value and converts it to a Boolean.
     *
     * @param key the value to get
     * @return the Boolean value, or {@code null} if the value is missing or cannot be converted
     */
    public Boolean getAsBoolean(String key) {
        Object value = mValues.get(key);
        try {
            return (Boolean) value;
        } catch (ClassCastException e) {
            if (value instanceof CharSequence) {
                return Boolean.valueOf(value.toString());
            } else if (value instanceof Number) {
                return ((Number) value).intValue() != 0;
            } else {
                println("Cannot cast value for " + key + " to a Boolean: " + value);
                return null;
            }
        }
    }

    /**
     * Gets a value that is a byte array. Note that this method will not convert
     * any other types to byte arrays.
     *
     * @param key the value to get
     * @return the {@code byte[]} value, or {@code null} is the value is missing or not a
     *         {@code byte[]}
     */
    public byte[] getAsByteArray(String key) {
        Object value = mValues.get(key);
        if (value instanceof byte[]) {
            return (byte[]) value;
        } else {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }


    /**
     * Returns a set of all of the keys
     *
     * @return a set of all of the keys
     */
    public Set<String> keySet() {
        return mValues.keySet();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String name : mValues.keySet()) {
            String value = getAsString(name);
            if (sb.length() > 0) sb.append(" ");
            sb.append(name + "=" + value);
        }
        return sb.toString();
    }
}
