package ir.civilization.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.collections4.iterators.IteratorIterable;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class JacksonUtils.
 */
public class JacksonUtils {

	private JacksonUtils() {
		// private constructor added to hide implicit public one
	}

	/**
	 * Checks if is property null or empty.
	 *
	 * @param node the node
	 * @param property the property
	 * @return true, if is property null or empty
	 */
	public static boolean isPropertyNullOrEmpty(JsonNode node, String property){
		return node == null || node.get(property)==null || node.get(property).isNull() || StringUtils.isBlank(node.get(property).asText());
	}

	/**
	 * Checks if is null.
	 *
	 * @param node the node
	 * @return true, if is null
	 */
	public static boolean isNull(JsonNode node){
		return node == null || node.isNull();
	}
	
	/**
	 * Checks if is not null.
	 *
	 * @param node the node
	 * @return true, if is not null
	 */
	public static boolean isNotNull(JsonNode node){
		return !isNull(node);
	}

	/**
	 * Gets the string from json node.
	 *
	 * @param node the node
	 * @param key the key
	 * @return the string from json node
	 */
	public static String getStringFromJsonNode(JsonNode node, String key) {
		JsonNode jsonNode = node.get(key);
		return (jsonNode == null) ? "" : jsonNode.asText();
	}

	/**
	 * Gets the boolean from json node.
	 *
	 * @param node the node
	 * @param key the key
	 * @param defaultValue the default value
	 * @return the boolean from json node
	 */
	public static boolean getBooleanFromJsonNode(JsonNode node, String key, boolean defaultValue) {
		JsonNode jsonNode = node.get(key);
		return (jsonNode == null) ? defaultValue : jsonNode.asBoolean();
	}
	
	/**
	 * Gets the json from object.
	 *
	 * @param obj the obj
	 * @return the json from object
	 */
	public static String getJsonFromObject(Object obj){
		try {
			return ObjectMapperProvider.getObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Exception!!!";
		}
	}
	
	/**
	 * Create and empty ArrayNode
	 *
	 * @return created ArrayNode
	 */
	public static ArrayNode createEmptyArrayNode() {
		return new ArrayNode(JsonNodeFactory.instance);
	}
	
	
	/**
	 * Create and empty ArrayNode
	 *
	 * @param x the string array 
	 * @return created ArrayNode
	 */
	public static ArrayNode createStringArrayNode(String... x) {
		ArrayNode arrayNode = createEmptyArrayNode();
		for (String s : x)
			arrayNode.add(s);
		return arrayNode;
	}

	
	/**
	 * Create and empty ObjectNode
	 * 
	 * @return empty ObjectNode
	 */
	public static ObjectNode createEmptyObjectNode() {
		return ObjectMapperProvider.getObjectMapper().createObjectNode();
	}
	
	
	/**
	 * Convert ObjecNode to String
	 *
	 * @return created String from ObjecNode
	 */
	public static String convertObjectNodeToString(ObjectNode objectNode) throws JsonProcessingException {
		return ObjectMapperProvider.getObjectMapper().writeValueAsString(objectNode);
	}
	
	/**
	 * Convert String to ObjecNode
	 *
	 * @return created ObjecNode from String
	 */
	public static JsonNode convertStringToJsonNode(String objectNodeStr) throws JsonProcessingException, IOException  {
		return ObjectMapperProvider.getObjectMapper().readTree(objectNodeStr);
	}
	
	
	protected static ObjectNode createErrorObjectNode(String errorMessage, String objectNodeString) {
		ObjectNode objectNode = createEmptyObjectNode();
		objectNode.put("error", errorMessage);
		objectNode.put("jsonNodeString", objectNodeString);
		return objectNode;
	}
	
	/**
	 * Create Error JsonNode
	 * 
	 * @param objectNodeStr the error message
	 * @return converted error to JsonNode
	 */
	public static JsonNode convertStringToJsonNodeOrErrorObjectNode(String objectNodeStr) {
		try {
			return convertStringToJsonNode(objectNodeStr);
		} catch (IOException e) {
			e.printStackTrace();
			return createErrorObjectNode(e.getMessage(), objectNodeStr);
		}
	}

	/**
	 * Create Error ObjectNode
	 * 
	 * @param objectNodeStr the error message
	 * @return converted error to ObjectNode
	 */
	public static ObjectNode convertStringToObjectNodeOrErrorObjectNode(String objectNodeStr) {
		JsonNode jsonNode = convertStringToJsonNodeOrErrorObjectNode(objectNodeStr);
		if (jsonNode instanceof ObjectNode)
			return (ObjectNode) jsonNode;
		return createErrorObjectNode("it is not an object node.", objectNodeStr);
	}
	
	
	/**
	 * Convert List<String> to ArrayNode
	 * 
	 * @param valueList the input String List
	 * @return created ArrayNode from String List
	 */
	public static ArrayNode convertToArrayNode(List<String> valueList) {
		ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);
		for (String values : valueList) {
			arrayNode.add(values);
		}
		return arrayNode;
	}

	public static <T> List<T> convertToList(JsonNode arrayData, Class<T> clazz) throws JsonProcessingException {
		if (isNull(arrayData))
			return null;
		if (!arrayData.isArray())
			throw new IllegalArgumentException("The value '"+arrayData+"' is not an array!");
		List<T> result = new ArrayList<>(); //TODO @SAhmad let the jackson do the for! use JacksonUtils.deserilizeObjectToList
		for (JsonNode childNode : new IteratorIterable<>(arrayData.iterator())) 
			result.add(deserilizeObject(childNode, clazz));
		return result;
	}
	
	/**
	 * Convert Object to String Json. This function search for getters with @JsonProperty Annotation 
	 * 
	 * @param obj the input Object
	 * @return created Json String
	 */
	public static String serializeObjectAsString(Object obj){
		if (obj == null)
			return null;
		ObjectMapper mapper = ObjectMapperProvider.getObjectMapper();
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * Convert Object to JsonNode. This function search for getters with @JsonProperty Annotation 
	 * 
	 * @param obj the input Object
	 * @return created JsonNode
	 */
	public static JsonNode serializeObjectAsJsonNode(Object obj) {
		if (obj == null)
			return null;
		ObjectMapper mapper = ObjectMapperProvider.getObjectMapper();
		return mapper.valueToTree(obj);
	}
	
	
	
	/**
	 * Convert JsonNode to given class
	 * 
	 * @param jsonNode the input JsonNode
	 * @param clazz the destination class
	 * @return created class instance
	 */
	public static <T> T deserilizeObject(JsonNode jsonNode, Class<T> clazz) throws JsonProcessingException {
		return ObjectMapperProvider.getForgivingObjectMapper().treeToValue(jsonNode, clazz);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> deserilizeObjectToList(JsonNode jsonNode, Class<T> clazz) {
		List<T> output = new ArrayList<>();
		if (jsonNode == null)
			return output;
		try {
			ObjectMapper mapper = ObjectMapperProvider.getForgivingObjectMapper();
			JsonParser jsonParser = mapper.treeAsTokens(jsonNode);
			Class<?> arrayClazz = Class.forName("[L" + clazz.getName() + ";");
			T[] readValue = (T[]) mapper.readValue(jsonParser, arrayClazz);
			for (T t : readValue) {
				output.add(t);
			}
			return output;
			//TODO @Kian. The following line doesn't work but the above implementation works!
			//return Arrays.asList(readValue);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Convert Json String to given class
	 * 
	 * @param string the given Json in string format
	 * @param clazz the destination class
	 * @return created class instance
	 */
	public static <T> T deserilizeObject(String string, Class<T> clazz) throws IOException {
		return ObjectMapperProvider.getForgivingObjectMapper().readValue(string, clazz);
	}

	
	/**
	 * Merge source ObjectNode into dest ObjecNode
	 * 
	 * @param source the source ObjectNode
	 * @param dest the destination ObjectNode
	 */
	public static void merge(ObjectNode source, ObjectNode dest) {
		for (String addedFieldName : new IteratorIterable<>(source.fieldNames())) {
			dest.set(addedFieldName, source.get(addedFieldName));
		}
	}
	
	/**
	 * Search inside node for a JsonNode with key "oldName" and change it keys to "newName"
	 * 
	 * @param node the ObjectNode that we want to rename some JsoneNode inside it.
	 * @param oldName the old name of JsonNode
	 * @param newName the new name of JsonNode
	 */
	public static void renamePropertyNotNull(ObjectNode node, String oldName, String newName){
		JsonNode value = node.get(oldName);
		if (isNull(value))
			return;
		node.remove(oldName);
		node.set(newName, value);
	}

	/**
	 * Check the input is null or is an empty ObjecNode
	 * 
	 * @param obj the input ObjectNode
	 * @return true if node is null or empty, false otherwise
	 */
	public static boolean isNullOrEmpty(ObjectNode obj) {
		return isNull(obj) || obj.size() == 0;
	}

}
