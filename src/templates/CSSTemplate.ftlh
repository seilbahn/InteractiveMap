.scheme {
	height: ${height}px;
	width: ${width}px;
	margin: 0 auto;
	position: relative;
}
.scheme svg {
	position: absolute;
	top: 0px;
	left: 0px;
	height: ${height}px;
	width: ${width}px;
}
.scheme polygon {
	fill: #${webPageObject.objectColor};
	cursor: pointer;
	opacity: ${webPageObject.objectOpacity};
}
.scheme polygon:hover, #hover {
	fill: #${webPageObject.objectHoverColor};
	opacity: ${webPageObject.objectHoverOpacity};
}
.scheme polygon.active {
	fill: #${webPageObject.objectActiveColor} !important;
	opacity: ${webPageObject.objectActiveOpacity};
}
.scheme-item {
	position: absolute;
	cursor: pointer;
}
.scheme-name {
	font-weight: bold;
	font-size: ${webPageObject.titleFont.getSize()}px;
	font-family:${webPageObject.titleFont.getFamily()};
	text-align: center;
	line-height: 13px;
}
.scheme-popup {
	display: none;
	border: 1px solid #777;
	padding: 10px;
	width: 200px;
	position: absolute;
	font-size: ${webPageObject.descriptionFont.getSize()}px;
	font-family:${webPageObject.descriptionFont.getFamily()};
	line-height: 14px;
	background: #fff;
	z-index: 9999;
	box-shadow: 0 0 10px rgba(0,0,0,0.5);
	text-align: left;
}