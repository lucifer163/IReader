package dhy.jc.reader.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 1.对象转换成Json字符串 2.List集合转换成Json字符串 3.Json字符串转换成对象 4.把Json字符串转换成包含对象的list集合
 * 5.把Json字符串转换成包含Map集合的List集合 6.把Json字符串转换成包含键值对映射的Map集合
 * 
 * @author Administrator
 * 
 */
public class JsonUtil {

	protected static Gson gson = new Gson();

	/**
	 * 对象转换成Json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String createJsonString(Object obj) {
		String str = gson.toJson(obj);
		return str;
	}

	/**
	 * List集合转换成Json字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String createJsonList(List list) {
		String str = gson.toJson(list);
		return str;
	}

	/**
	 * Json字符串转换成对象
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T changeJsonToObject(String jsonString, Class<T> cls) {
		T t = null;
		try {
			t = gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}

	/**
	 * 把Json字符串转换成包含对象的list集合
	 * 
	 * @param json
	 * @param cls
	 * @return
	 */
	public static <T> ArrayList<T> changeGsonToList(String json, Class<T> cls) {
		Type type = new TypeToken<ArrayList<JsonObject>>() {
		}.getType();
		ArrayList<JsonObject> jsonObjs = new Gson().fromJson(json, type);// �����л���ArrayList<JsonObject>��
		ArrayList<T> listOfT = new ArrayList<T>();
		for (JsonObject jsonObj : jsonObjs) {
			listOfT.add(new Gson().fromJson(jsonObj, cls));
		}

		return listOfT;
	}

	/**
	 * 把Json字符串转换成包含Map集合的List集合
	 * 
	 * @param gsonString
	 * @return
	 */
	public static <T> List<Map<String, T>> changeGsonToListMaps(
			String gsonString) {
		List<Map<String, T>> list = null;
		list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
		}.getType());
		return list;
	}

	/**
	 * 把Json字符串转换成包含键值对映射的Map集合
	 * 
	 * @param gsonString
	 * @return
	 */
	public static <T> Map<String, T> changeGsonToMaps(String gsonString) {
		Map<String, T> map = null;
		map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
		}.getType());
		return map;
	}
}
