package com.octopus.customerManagement.businessLogic.implementation;

import com.octopus.customerManagement.businessLogic.interfaces.IPatchUtility;
import org.json.JSONObject;
import org.sonatype.sisu.siesta.common.error.BadRequestException;

import java.util.Arrays;

public class PatchUtility implements IPatchUtility {
    public String[] extractKeys(String path) {
        String leadingSlash = "/";
        if (!path.startsWith(leadingSlash)) throw new BadRequestException("Path must begin with a leading '/'");

        return path.substring(1).split(leadingSlash);
    }

    public JSONObject addValue(String value, JSONObject jsonObject, String[] keys) throws BadRequestException {
        String currentKey = keys[0];

        if (keys.length == 1) {
            return jsonObject.put(currentKey, value);
        } else if (!jsonObject.has(currentKey)) {
            throw new BadRequestException(currentKey + "is not a valid key.");
        }

        JSONObject nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
        String[] remainingKeys = Arrays.copyOfRange(keys, 1, keys.length);
        JSONObject updatedNestedValue = addValue(value, nestedJsonObjectVal, remainingKeys);
        return jsonObject.put(currentKey, updatedNestedValue);
    }

    public JSONObject removeValue(JSONObject jsonObject, String[] keys) throws BadRequestException {
        String currentKey = keys[0];

        if (keys.length == 1 && jsonObject.has(currentKey)) {
            jsonObject.remove(currentKey);
            return jsonObject;
        } else if (!jsonObject.has(currentKey)) {
            throw new BadRequestException(currentKey + "is not a valid key.");
        }

        JSONObject nestedJsonObjectVal = jsonObject.getJSONObject(currentKey);
        int nextKeyIdx = 1;
        String[] remainingKeys = Arrays.copyOfRange(keys, nextKeyIdx, keys.length);
        JSONObject updatedNestedValue = removeValue(nestedJsonObjectVal, remainingKeys);
        return jsonObject.put(currentKey, updatedNestedValue);
    }
}
