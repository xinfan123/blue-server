package com.xinfan.msgbox.http.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

public class AvatarUtils {

	public static final String AVATAR_PATH = "/file/avatar";

	public static String save(HttpServletRequest request, String images) {

		if (images == null || images.length() < 100) {
			return "";
		}

		String base = request.getRealPath(AVATAR_PATH);

		String name = String.valueOf(System.nanoTime()) + ".jpg";

		try {
			FileUtils.writeByteArrayToFile(new File(base + "/" + name), Base64.decodeBase64(images));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return name;
	}

	public static String get(HttpServletRequest request, String name) {

		if (name == null || name.trim().length() == 0) {
			return "";
		}

		String base = request.getRealPath(AVATAR_PATH);

		try {

			byte[] images = FileUtils.readFileToByteArray(new File(base + "/" + name));

			return Base64.encodeBase64String(images);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}

}
