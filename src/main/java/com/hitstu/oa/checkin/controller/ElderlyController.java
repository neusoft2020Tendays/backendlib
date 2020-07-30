package com.hitstu.oa.checkin.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hitstu.oa.checkin.model.ElderlyModel;
import com.hitstu.oa.checkin.service.IElderlyService;
import com.hitstu.oa.checkin.service.IWardService;
import com.hitstu.oa.restresult.Result;

@RestController
@RequestMapping(value = "/elderly")
@CrossOrigin(origins = { "*", "null" })
public class ElderlyController {

	@Autowired
	private IElderlyService elderlyService = null;

	@Autowired
	private IWardService wardService = null;

	@PostMapping(value = "/add")
	public Result<String> add(ElderlyModel elderlyModel, @RequestParam(required = false) MultipartFile elderlyPhoto)
			throws Exception {
		Result<String> result = new Result<>();
		Result<ElderlyModel> search = this.getById(elderlyModel.getElderlyid());
		result.setStatus("ERROR");
		if (search.getResult() != null) {
			result.setMessage("老人 " + elderlyModel.getElderlyid() + " 已存在！");
		} else if (!elderlyModel.getEldersex().equals("男") && !elderlyModel.getEldersex().equals("女")) {
			result.setMessage("性别必须为“男”或“女”");
		} else if (elderlyModel.getElderage() <= 0 || elderlyModel.getElderage() >= 150) {
			result.setMessage("年龄 " + elderlyModel.getElderage() + " 不合法！");
		} else {
			if (elderlyPhoto != null && (!elderlyPhoto.isEmpty())) {
				// 目标文件地址
				File dist = new File("D:\\DriveY\\neosoft2020\\webroot\\photo\\" + elderlyPhoto.getOriginalFilename());
				elderlyModel.setPhotoFileName(elderlyPhoto.getOriginalFilename());
				elderlyModel.setPhotoContentType(elderlyPhoto.getContentType());
				// 取得文件的字节
				elderlyModel.setPhoto(elderlyPhoto.getBytes());
				// 保存上传文件到目标目录
				elderlyPhoto.transferTo(dist);

			}
			elderlyService.add(elderlyModel);
			result.setStatus("OK");
			result.setMessage("增加老人成功！");
		}
		return result;
	}

	@PostMapping(value = "/modify")
	public Result<String> modify(@RequestBody ElderlyModel elderlyModel) throws Exception {
		Result<String> result = new Result<>();
		result.setStatus("ERROR");
		if (!elderlyModel.getEldersex().equals("男") && !elderlyModel.getEldersex().equals("女")) {
			result.setMessage("性别必须为“男”或“女”");
		}
//		else if (!new HashSet<>(wardService.getFloorByAll()).contains(elderlyModel.getFloor())) {
//			result.setMessage("楼层 " + elderlyModel.getFloor() + " 不存在！");
//		} else if (new HashSet<>(wardService.getFloorByAll()).contains(elderlyModel.getFloor())
//				&& !new HashSet<>(wardService.getRoomByFloor(elderlyModel.getFloor()))
//						.contains(elderlyModel.getRoom())) {
//			result.setMessage("楼层 " + elderlyModel.getFloor() + " 的房间 " + elderlyModel.getRoom() + " 不存在！");
//		} else if (new HashSet<>(wardService.getFloorByAll()).contains(elderlyModel.getFloor())
//				&& new HashSet<>(wardService.getRoomByFloor(elderlyModel.getFloor())).contains(elderlyModel.getRoom())
//				&& !new HashSet<>(wardService.getWardByFloorAndRoom(elderlyModel.getFloor(), elderlyModel.getRoom()))
//						.contains(elderlyModel.getBed())) {
//			result.setMessage("楼层 " + elderlyModel.getFloor() + " 的房间  " + elderlyModel.getRoom() + " 中的床位号 "
//					+ elderlyModel.getBed() + " 不存在！");
//		} 
		else if (elderlyModel.getElderage() <= 0 || elderlyModel.getElderage() > 150) {
			result.setMessage("年龄 " + elderlyModel.getElderage() + " 不合法！");
		} else {
			elderlyService.modify(elderlyModel);
			result.setStatus("OK");
			result.setMessage("增加老人成功！");
		}
		return result;
	}

	@PostMapping(value = "/update/photo")
	public Result<String> updatePhoto(ElderlyModel elderlyModel,
			@RequestParam(required = false) MultipartFile employeePhoto) throws Exception {
		if (employeePhoto != null && (!employeePhoto.isEmpty())) {
			elderlyModel.setPhoto(employeePhoto.getBytes());
			elderlyModel.setPhotoFileName(employeePhoto.getOriginalFilename());
			elderlyModel.setPhotoContentType(employeePhoto.getContentType());
		}
		elderlyService.modifyPhoto(elderlyModel);
		Result<String> result = new Result<String>();
		result.setStatus("OK");
		result.setMessage("修改员工照片成功!");
		return result;
	}

	@PostMapping(value = "/delete")
	public Result<String> delete(@RequestBody ElderlyModel elderlyModel) throws Exception {
		elderlyService.delete(elderlyModel);
		Result<String> result = new Result<>();
		result.setStatus("OK");
		result.setMessage("删除老人成功！");
		return result;
	}

	// 取得部门列表，分页模式
	@GetMapping(value = "/list/all/page")
	public Result<ElderlyModel> getListByAllWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page) throws Exception {
		Result<ElderlyModel> result = new Result<>();
		result.setCount(elderlyService.getCountByAll());
		result.setPageCount(elderlyService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(elderlyService.getByAllWithPage(rows, page));
		result.setStatus("OK");
		result.setMessage("老人列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/list/condition/page")
	public Result<ElderlyModel> getListByConditionWithPage(@RequestParam(required = false, defaultValue = "5") int rows,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "0") int minAge,
			@RequestParam(required = false, defaultValue = "0") int maxAge,
			@RequestParam(required = false, defaultValue = "所有楼层") String floor,
			@RequestParam(required = false, defaultValue = "所有房间") String room,
			@RequestParam(required = false, defaultValue = "") String nameKey) throws Exception {
		Result<ElderlyModel> result = new Result<>();
		result.setCount(elderlyService.getCountByAll());
		result.setPageCount(elderlyService.getPageCountByAll(rows));
		result.setRows(rows);
		result.setPage(page);
		result.setList(elderlyService.getListByConditionWithPage(rows, page, minAge, maxAge, floor, room, nameKey));
		result.setStatus("OK");
		result.setMessage("老人列表分页方式成功！");
		return result;
	}

	@GetMapping(value = "/get")
	public Result<ElderlyModel> getById(@RequestParam(required = true) String id) throws Exception {
		Result<ElderlyModel> result = new Result<>();
		result.setResult(elderlyService.getById(id));
		if (result.getResult() == null) {
			result.setStatus("ERROR");
			result.setMessage("老人" + id + "不存在！");
		} else {
			result.setStatus("OK");
			result.setMessage("获取老人成功！");
		}
		return result;
	}

	@RequestMapping("/photo")
	public ResponseEntity<byte[]> showPhoto(@RequestParam String id) throws Exception {
		ElderlyModel elderyModel = elderlyService.getById(id);

		// 如果图片保存在不能直接访问的目录中，如/WEB-INF/photo
		// 通过Java I/O流 InputStream 读取到byte数组。。
		// InputStream in=new
		// FileInputStream(""d:/webroot/WEB-INF/photo/"+em.getPath());
		// byte[] data=new byte[in.avaliable()];
		// in.read(data);

		if (elderyModel != null && elderyModel.getPhotoContentType() != null) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("Content-Type", elderyModel.getPhotoContentType());
			// return new ResponseEntity<byte[]>(data, responseHeaders,HttpStatus.OK);
			return new ResponseEntity<byte[]>(elderyModel.getPhoto(), responseHeaders, HttpStatus.OK);
		} else {
			return null;
		}
	}

}
