package com.nhncorp.edu.sample.board.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhncorp.lucy.spring.core.data.DataHandler;
import com.nhncorp.lucy.spring.core.data.DataHandlerFactory;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException {
		doPost(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException {
		String fileRealName = req.getParameter("fileRealName");

		DataHandler dataHandler = DataHandlerFactory.getDataHandler();

		File file = new File(dataHandler.get("filepath") + fileRealName);

		OutputStream out = null;
		FileInputStream fis = null;

		try {
			if (file.exists()) {
				out = res.getOutputStream();

				fis = new FileInputStream(file);

				byte[] imgBytes = new byte[(int) file.length()];

				fis.read(imgBytes);

				res.setContentType("application/unkown");
				res.setContentLength(imgBytes.length);

				out.write(imgBytes, 0, imgBytes.length);
				out.flush();
			} else {
				res.setContentType("application/unkown");
				res.setContentLength(0);
			}
		} catch (Exception e) {
			res.setContentType("application/unkown");
			res.setContentLength(0);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}

			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
