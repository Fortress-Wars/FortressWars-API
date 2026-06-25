package net.fortresswars.core.profiles;

import net.fortresswars.api.requests.CosmeticsProfileRequest;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CosmeticsProfile {

    private final UUID uuid;
    private final Map<String, String>  equippedCosmetics;

    public CosmeticsProfile(CosmeticsProfileRequest profileRequest) {
        this.uuid = profileRequest.uuid();
        this.equippedCosmetics = new ConcurrentHashMap<>(profileRequest.equippedCosmetics());
    }

    public CosmeticsProfileRequest toUpdateRequest() {
        final UUID uuid = this.uuid;
        return new CosmeticsProfileRequest(uuid, this.equippedCosmetics);
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean hasEquippedCosmetic(String cosmeticType) {
        return equippedCosmetics.containsKey(cosmeticType);
    }

    public String getEquippedCosmetic(String cosmeticType) {
        return equippedCosmetics.get(cosmeticType);
    }

    public void setEquippedCosmetic(String cosmeticType, String cosmeticValue) {
        equippedCosmetics.put(cosmeticType, cosmeticValue);
    }

    public void removeEquippedCosmetic(String cosmeticType) {
        equippedCosmetics.remove(cosmeticType);
    }
}
