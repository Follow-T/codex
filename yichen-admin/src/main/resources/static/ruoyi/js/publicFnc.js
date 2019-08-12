var publicFnc = {
	/**
	 * 获取目标类型
	 * 
	 * @param item 目标参数
	 */
	getType : function(item) {
		var type = Object.prototype.toString.call(item);
		return type.slice(type.indexOf(' ') + 1, -1);
	},
	/**
	 * 检查文件类型是否和目标类型一致
	 * 
	 * @param type 文件类型
	 * @param targetType 目标类型
	 */
	checkFileType : function(type, targetType) {
		var _type = publicFnc.getType(targetType);
		if (_type === 'String') {
			if (type !== targetType)
				return '文件格式必须是' + targetType;
		} else if (_type === 'Array') {
			var flag = targetType.some(function(item) {
				return item === type;
			});
			if (!flag)
				return '文件格式必须是' + targetType.toString() + '之一';
		}
		if (_type !== 'String' && _type !== 'Array')
			return false;
		return 'pass';
	},
	/**
	 * 检查文件大小是否小于等于目标大小
	 * 
	 * @param size 文件大小
	 * @param maxSize 目标大小
	 */
	checkFileSize : function(size, maxSize) {
		return size > maxSize ? '文件必须小于' + (maxSize / 1024) + 'M' : 'pass';
	},
	/**
	 * 上传文件
	 * 
	 * @param url 接口地址
	 * @param targetFile dom直接获取的file
	 * @param targetType 目标类型
	 * @param maxSize 文件最大体积
	 * @param data 上传的文件具体formData
	 */
	uploadFiles : function(url, targetFile, targetType, maxSize, data) {
		if (!url || publicFnc.getType(url) !== 'String' || !targetFile || publicFnc.getType(targetFile) !== 'FileList' || !targetType || !maxSize || isNaN(maxSize - 0) || !data) return false;
		var file = targetFile[0], 
				type = file && file.name && file.name.split('.').pop(), 
				size = file && file.size, 
				checkType = publicFnc.checkFileType(type, targetType), 
				checkSize = publicFnc.checkFileSize(size, maxSize), 
				checkRes = '', 
				xhr = new XMLHttpRequest();
		if (checkType !== 'pass') checkRes = checkType;
		if (checkSize !== 'pass') checkRes = checkRes || checkSize;
		if (!checkRes) {
			xhr.open('POST', url, true);
			xhr.responseType = 'json';
			xhr.send(data);
		}
		return {
			on : function(state, callBack) {
				this[state](callBack);
			},
			done : function(cb) {
				if (!checkRes) {
					xhr.onreadystatechange = function() {
						if (xhr.status === 200 && xhr.readyState === 4) {
							cb.call(this, JSON.parse(JSON.stringify(xhr.response)));
						}
					}
				} else {
					cb.call(this, {
						msg : checkRes
					});
				}
			}
		}
	},
	/**
	 * 添加事件
	 * 
	 * @param ele 元素
	 * @param type 事件类型
	 * @param fn 回调函数
	 */
	addEvent : function(ele, type, fn) {
		var doms = document.querySelectorAll(ele);
		Array.prototype.forEach.call(doms, function(item, index) {
			item.addEventListener(type, function(event) {
				return fn.call(this, event)
			});
		})
	}
}
