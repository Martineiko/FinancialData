package com.dw.Utileria;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utileria {
	public String generarPassword(int size) {
		String salt = "abchefghknpqrstuvwxyz";
		salt += "ACDEFHKNPRSTUVWXYZ";
		salt += "0123456789";
		int tamaño = salt.length() - 1;
		String pass = "";
		for (int i = 0; i < size; i++) {
			int random = (int) (Math.random() * tamaño + 0);
			pass += salt.substring(random, random + 1);
		}

		return pass;
	}

	public Map<String, Object> jsonToMap(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			Map<String, Object> map = new HashMap<String, Object>();

			map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});

			return map;

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Map<String, Object>> jsonToListMap(String json) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();

			map = mapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {
			});

			return map;

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String converListMapGson(List<Map<String, Object>> list) {
		Gson gson = new Gson();
		gson = new GsonBuilder().serializeNulls().create();
		String json = gson.toJson(list);
		return json;
	}

	public int validarEntero(Object cadena) {
		int numero = 0;
		try {
			numero = Integer.parseInt("" + cadena);
		} catch (NumberFormatException e) {
			return 0;
		}
		return numero;
	}

	public float validarFloat(Object cadena) {
		float numero = 0;
		try {

			numero = Float.parseFloat("" + cadena);
			if (Float.isNaN(numero)) {
				return 0;
			}
		} catch (NumberFormatException e) {
			return 0;
		}
		return numero;
	}

	public String validarCadena(Object cadena) {
		String valorCorregido;
		if (cadena == null) {
			return "";
		}
		valorCorregido = "" + cadena;
		valorCorregido = valorCorregido.replace("null", "");
		return valorCorregido.trim();
	}

	public void enviarSessionObjeto(HttpServletRequest request, String cadenaNombre, Object valor) {
		HttpSession misession = (HttpSession) request.getSession(true);
		misession.setAttribute(cadenaNombre, valor);

	}

	public Object obtenerSessionObjeto(HttpServletRequest request, String cadenaNombre) {
		Object sesion;
		HttpSession misession = (HttpSession) request.getSession();
		sesion = misession.getAttribute(cadenaNombre);
		return sesion;
	}

	public ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

	public String getFileWithUtil(String fileName) {

		String result = "";

		ClassLoader classLoader = getClass().getClassLoader();

		result = classLoader.getResource(fileName).toString();

		return result;
	}
}
