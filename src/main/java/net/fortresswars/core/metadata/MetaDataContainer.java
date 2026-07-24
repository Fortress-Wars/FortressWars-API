package net.fortresswars.core.metadata;

import org.bukkit.metadata.Metadatable;

import java.util.HashMap;
import java.util.Map;

public class MetaDataContainer {

    private final Map<MetaDataKey, Object> metaDataMap;

    public void applyMetaData(Metadatable m) {
        MetaDataStore.reset(m);
        for (MetaDataKey key : MetaDataKey.values()) {
            Object value = get(key);
            MetaDataStore.setMetaData(m, key, value);
        }
    }

    public MetaDataContainer(Metadatable m) {
        metaDataMap = new HashMap<>();
        for (MetaDataKey key : MetaDataKey.values()) {
            Object value = MetaDataStore.getObject(m, key);
            if (value == null) continue;
            metaDataMap.put(key, value);
        }
    }

    public void put(MetaDataKey key, Object object) {
        metaDataMap.put(key, object);
    }

    public Object get(MetaDataKey key) {
        return metaDataMap.getOrDefault(key, null);
    }

    public void clear() {
        metaDataMap.clear();
    }

    public boolean has(MetaDataKey metaDataKey) {
        return metaDataMap.containsKey(metaDataKey);
    }

    public boolean hasAny() {
        for (MetaDataKey key : MetaDataKey.values()) {
            if (has(key)) return true;
        }
        return false;
    }
}
