package com.nhuocquy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhuocquy.myfile.MyFile;
import com.nhuocquy.myfile.MyFileException;
import com.nhuocquy.myfile.MyStatus;


@Controller
public class ImageController {
	@Autowired
	public  String IMAGE_DIR;
	public static final String FORMAT_DIR_IMAGE = "%s" + File.separator + "%d%s";
	@RequestMapping(value = "/image", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MyFile  getImages(@RequestParam(value = "filename") String fileName) {
		MyFile f = new MyFile(IMAGE_DIR + File.separator + fileName);
		 f.setFileName(fileName);
		 return f;
	}
	@RequestMapping(value = "/image", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MyStatus  upImages(@RequestBody MyFile image)  {
		MyStatus myStatus = new MyStatus();
//		File f = new File(IMAGE_DIR +  + System.currentTimeMillis() + image.retrieveExtendName());
		File f = new File(String.format(FORMAT_DIR_IMAGE, IMAGE_DIR, System.currentTimeMillis(), image.retrieveExtendName()));
		BufferedOutputStream bos;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(f));
			bos.write(image.getData());
			bos.flush();
			bos.close();
			myStatus.setCode(MyStatus.CODE_SUCCESS);
			myStatus.setMessage(MyStatus.MESSAGE_SUCCESS);
			myStatus.setObj(f.getName());
		} catch (IOException | MyFileException e) {
			e.printStackTrace();
			myStatus.setCode(MyStatus.CODE_FAIL);
			myStatus.setMessage(MyStatus.MESSAGE_FAIL);
		}
		return myStatus;
	}
	@RequestMapping(value = "/s")
	public @ResponseBody MyStatus getS(){
		return new MyStatus(1, IMAGE_DIR);
	}
}
