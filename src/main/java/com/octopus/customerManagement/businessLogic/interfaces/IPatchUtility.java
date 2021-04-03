package com.octopus.customerManagement.businessLogic.interfaces;

import org.json.JSONObject;
import org.sonatype.sisu.siesta.common.error.BadRequestException;

public interface IPatchUtility {
    String[] extractKeys(String path);
    JSONObject addValue(String value, JSONObject jsonObject, String[] keys) throws BadRequestException;
    JSONObject removeValue(JSONObject jsonObject, String[] keys) throws BadRequestException;
}
