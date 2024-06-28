
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>add</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="AddServlet" id="addForm">
            <div class="form-group">
                <div class="label">
                    <label>水果编号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="number" data-validate="required:请输入水果编号" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>水果名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="name" data-validate="required:请输入水果名称" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>水果图片：</label>
                </div>
                <div class="field">
                    <img src="" class="img-border margin-left" alt="请上传图片" width="90" height="60" id="picture"/>
                    <input type="button" class="button bg-blue margin-left" id="btn-upload" value="浏览上传"  style="float:left;">
                    <input class="file-upload" type="file" accept="image/*" name="picture"/>
                </div>

            </div>

            <div class="form-group">
                <div class="label">
                    <label>水果单价：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="price" value="0"  data-validate="currency:单价必须为数字" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>计价单位：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="unit" data-validate="required:请输入计价单位" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"  onclick="uploadFile()"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>

<!-- 模态框 -->
<div id="myModal" class="modal">
    <div class="modal-content">
        <h4>文件上传中</h4>
        <p id="countdown">倒计时: <span id="timer"></span></p>
    </div>
</div>

</html>

