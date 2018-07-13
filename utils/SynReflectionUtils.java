package synergix.th6.framework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * Define some utilities relates to Reflection.
 *
 */
public class SynReflectionUtils {
	private SynReflectionUtils() {

	}

	public static Object invokeGetMehod(final Object obj, final String field) {
		final Class<?> cls = obj.getClass();
		try {
			final Method mth = cls.getMethod(SynReflectionUtils.getGetterName(field), new Class[] {});
			return mth.invoke(obj, new Object[] {});
		}
		catch (final Throwable e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static void invokeSetMethod(final Object obj, final String field, final Object value) {
		final Class<?> cls = obj.getClass();
		final Method[] mths = cls.getMethods();
		final String setterMth = SynReflectionUtils.getSetterName(field);
		for (final Method method : mths) {
			if (method.getName().equals(setterMth) && method.getParameterTypes().length == 1) {
				try {
					method.invoke(obj, new Object[] { value });
					break;
				}
				catch (final Throwable e) {
					throw new IllegalArgumentException(e);
				}
			}
		}
	}

	public static void invokeFieldAssignment(final Object obj, final Field field, final Object value) {
		try {
			field.setAccessible(true);
			field.set(obj, value);
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}


	public static Object evaluateExpressionPath(final Object sourceInstance, final String expressionPath) {
		final List<String> pathPartials = new ArrayList<String>();
		final StringTokenizer tokenizer = new StringTokenizer(expressionPath, "\\.");
		while (tokenizer.hasMoreTokens()) {
			pathPartials.add(tokenizer.nextToken());
		}

		Object currentInstance = sourceInstance;
		for (final String pathParrial : pathPartials) {
			if (currentInstance == null) {
				return currentInstance;
			}
			currentInstance = SynReflectionUtils.invokeGetMehod(currentInstance, pathParrial);
		}
		return currentInstance;
	}

	public static String getGetterName(final String field) {
		return new StringBuffer("get").append(SynReflectionUtils.toFirstUpperCase(field)).toString();
	}

	public static String getSetterName(final String field) {
		return new StringBuffer("set").append(SynReflectionUtils.toFirstUpperCase(field)).toString();
	}

	private static String toFirstUpperCase(final String stringValue) {
		final StringBuffer sb = new StringBuffer(stringValue);
		if (sb.length() > 0) {
			final char firstChar = Character.toUpperCase(sb.charAt(0));
			sb.setCharAt(0, firstChar);
		}

		return sb.toString();
	}

	public static Class<?> getFieldJavaType(final Object obj, final String field) {
		try {
			return SynReflectionUtils.invokeOrEvaludate(obj, field).getClass();
		}
		catch (final Throwable e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static Object invokeOrEvaludate(final Object obj, final String field) {
		if (field.contains(".")) {
			return SynReflectionUtils.evaluateExpressionPath(obj, field);
		}
		else {
			return SynReflectionUtils.invokeGetMehod(obj, field);
		}
	}

	public static Object invokeFindMethodForSinglePkEntity(final Class<?> cls, final String code) {
		final Method[] mths = cls.getMethods();
		for (final Method method : mths) {
			if (method.getName().equals("find") && method.getParameterTypes().length == 1) {
				try {
					return method.invoke(cls.newInstance(), new Object[] { code });
				}
				catch (final Throwable e) {
					throw new IllegalArgumentException(e);
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T newInstanceFromClassName(final String className) {
		try {
			return (T) Class.forName(className).newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


	/**
	 * Invoked this method when you know for sure that the className is valid.
	 * Incase the the className is invalid, we consider this as programming error and will cause RuntimeException
	 *
	 * @param className
	 * @return
	 */
	public static <T> Class<T> getClassForName(final String className) {
		try {
			@SuppressWarnings("unchecked")
			final Class<T> returnedClazz = (Class<T>) Class.forName(className);

			return returnedClazz;
		}
		catch (final ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T newInstanceFromClass(final Class<T> clazz) {
		try {
			return clazz.newInstance();
		}
		catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public static Field getPkField(final Class<?> entityClass) {
		return FieldUtils.getField(entityClass, "pk", true);
	}

	public static Map<String, Field> getMapOfFieldNameAndField(final Class<?> clazz) {
		final Map<String, Field> mapOfFieldNameAndField = new HashMap<>();

		for (final Field field : FieldUtils.getAllFieldsList(clazz)) {
			mapOfFieldNameAndField.put(field.getName(), field);
		}

		return mapOfFieldNameAndField;
	}

	public static boolean isValidClassName(final String className) {
		try {
			Class.forName(className);
			return true;
		}
		catch (final ClassNotFoundException e) {
			return false;
		}
	}
}
