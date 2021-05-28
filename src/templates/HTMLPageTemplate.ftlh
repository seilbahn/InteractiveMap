<!DOCTYPE html>
<html lang="ru">
<head>
    <title>${title}</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script src="jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="scheme">
    <img src="${image}" alt="">
    <svg>
        <#list webPageObjectArrayList as webPageObject>
            <polygon data-id="${webPageObject.objectId}" points="${webPageObject.points}"></polygon>
        </#list>
    </svg>
    <#list webPageObjectArrayList as webPageObject>
        <div class="scheme-item" data-id="${webPageObject.objectId}"
             style="top: ${webPageObject.leftPoint}px; left: ${webPageObject.topPoint}px;">
            <div class="scheme-name">${webPageObject.title}</div>
            <div class="scheme-popup">
                ${webPageObject.description}
            </div>
        </div>
    </#list>
</div>
<script src="script.js"></script>
</body>
</html>