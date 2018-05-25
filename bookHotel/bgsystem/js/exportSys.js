$(".exportBtn").mouseenter(
	function(){
		var obj = $(this);
		obj.css("background","#41b8b1");
		obj.css("color","white");
		obj.children("img").attr("src","img/export2.png");
	}
);
$(".exportBtn").mouseleave(
	function(){
		var obj = $(this);
		obj.css("background","white");
		obj.css("color","#2c2c2c");
		obj.children("img").attr("src","img/export.png");
	}
);
$(".exportBtn").click(
	function(){
			$(".messageTable").table2excel({
                // 不被导出的表格行的CSS class类
                exclude: ".noExl",
                // 导出的Excel文档的名称，（没看到作用）
                name: "Excel Document Name",
                // Excel文件的名称
                filename: "myExcelTable.xls"
            });
	}
);