<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Blueprint: Zoom Slider</title>
	<meta name="description" content="A simple content slider with depth-like zoom functionality" />
	<meta name="keywords" content="blueprint, template, slider, zoom, javascript, depth, 3d, css" />
	<meta name="author" content="Codrops" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
	<!-- Feather Icons -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/feather/style.css">
	<!-- General demo styles & header -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/demo.css" />
	<!-- Component styles -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/component.css" />
	<script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.js"></script>
</head>
<body>
	<!-- Main container -->
	<div class="container">
		<!-- Blueprint header -->
		<header class="bp-header cf">
			<span>Blueprint <span class="bp-icon bp-icon-about" data-content="The Blueprints are a collection of basic and minimal website concepts, components, plugins and layouts with minimal style for easy adaption and usage, or simply for inspiration."></span></span>
			<h1>Zoom Slider</h1>
			<nav>
				<a href="http://tympanus.net/Blueprints/FilterableProductGrid/" class="bp-icon bp-icon-prev" data-info="previous Blueprint"><span>Previous Blueprint</span></a>
				<!--a href="" class="bp-icon bp-icon-next" data-info="next Blueprint"><span>Next Blueprint</span></a-->
				<a href="http://tympanus.net/codrops/?p=24330" class="bp-icon bp-icon-drop" data-info="back to the Codrops article"><span>back to the Codrops article</span></a>
				<a href="http://tympanus.net/codrops/category/blueprints/" class="bp-icon bp-icon-archive" data-info="Blueprints archive"><span>Go to the archive</span></a>
			</nav>
		</header>
		<!-- Grid -->
		<section class="slider">
			<div class="slide slide--current" data-content="content-1">
				<div class="slide__mover">
					<div class="zoomer flex-center">
						<img class="zoomer__image" src="${pageContext.request.contextPath}/resources/images/iphone.png" alt="iPhone" />
						<div class="preview">
							<img src="${pageContext.request.contextPath}/resources/images/iphone-content-preview.png" alt="iPhone app preview" />
							<div class="zoomer__area zoomer__area--size-2"></div>
						</div>
					</div>
				</div>
				<h2 class="slide__title"><span>The Classy</span> iPhone 6</h2>
			</div>
			<div class="slide" data-content="content-2">
				<div class="slide__mover">
					<div class="zoomer flex-center">
						<img class="zoomer__image" src="${pageContext.request.contextPath}/resources/images/ipad.png" alt="iPad Mini" />
						<div class="preview">
							<img src="${pageContext.request.contextPath}/resources/images/ipad-content-preview.png" alt="iPad Mini app preview" />
							<div class="zoomer__area zoomer__area--size-4"></div>
						</div>
					</div>
				</div>
				<h2 class="slide__title"><span>The Fantastic</span> iPad Mini</h2>
			</div>
			<div class="slide" data-content="content-3">
				<div class="slide__mover">
					<div class="zoomer flex-center">
						<img class="zoomer__image" src="${pageContext.request.contextPath}/resources/images/macbook.png" alt="MacBook" />
						<div class="preview">
							<img src="${pageContext.request.contextPath}/resources/images/macbook-content-preview.jpg" alt="MacBook app preview" />
							<div class="zoomer__area zoomer__area--size-3"></div>
						</div>
					</div>
				</div>
				<h2 class="slide__title"><span>The Amazing</span> MacBook</h2>
			</div>
			<div class="slide" data-content="content-4">
				<div class="slide__mover">
					<div class="zoomer flex-center">
						<img class="zoomer__image" src="${pageContext.request.contextPath}/resources/images/imac.png" alt="iMac" />
						<div class="preview">
							<img src="${pageContext.request.contextPath}/resources/images/imac-content-preview.jpg" alt="iMac app preview" />
							<div class="zoomer__area zoomer__area--size-5"></div>
						</div>
					</div>
				</div>
				<h2 class="slide__title"><span>The Glorious</span> iMac</h2>
			</div>
			<div class="slide" data-content="content-5">
				<div class="slide__mover">
					<div class="zoomer flex-center">
						<img class="zoomer__image" src="${pageContext.request.contextPath}/resources/images/apple-watch.png" alt="Apple Watch" />
						<div class="preview rounded">
							<img src="${pageContext.request.contextPath}/resources/images/apple-watch-content-preview.png" alt="Apple Watch app preview" />
							<div class="zoomer__area zoomer__area--size-1"></div>
						</div>
					</div>
				</div>
				<h2 class="slide__title"><span>The Fabulous</span> Apple Watch</h2>
			</div>
			<nav class="slider__nav">
				<button class="button button--nav-prev"><i class="icon icon--arrow-left"></i><span class="text-hidden">Previous product</span></button>
				<button class="button button--zoom"><i class="icon icon--zoom"></i><span class="text-hidden">View details</span></button>
				<button class="button button--nav-next"><i class="icon icon--arrow-right"></i><span class="text-hidden">Next product</span></button>
			</nav>
		</section>
		<!-- /slider-->
		<section class="content">
			<div class="content__item" id="content-1">
				<img class="content__item-img rounded-right" src="${pageContext.request.contextPath}/resources/images/iphone-content.png" alt="Apple Watch Content" />
				<div class="content__item-inner">
					<h2>The iPhone 6</h2>
					<h3>Incredible performance for powerful apps</h3>
					<p>Built on 64-bit desktop-class architecture, the new A8 chip delivers more power, even while driving a larger display. The M8 motion coprocessor efficiently gathers data from advanced sensors and a new barometer. And with increased battery life, iPhone 6 lets you do more, for longer than ever.</p>
					<p><a href="https://www.apple.com/iphone-6/technology/">Learn more about this technology &xrarr;</a></p>
				</div>
			</div>
			<div class="content__item" id="content-2">
				<img class="content__item-img rounded-right" src="${pageContext.request.contextPath}/resources/images/ipad-content.jpg" alt="iPad Mini Content" />
				<div class="content__item-inner">
					<h2>The iPad Mini</h2>
					<h3>Desktop-class architecture without a desktop</h3>
					<p>Don��t let its size fool you. iPad mini 3 is powered by an A7 chip with 64-bit desktop-class architecture. A7 delivers amazing processing power without sacrificing battery life. So you get incredible performance in a device you can take with you wherever you go.</p>
					<p><a href="https://www.apple.com/ipad-mini-3/performance/">Learn more about Performance &xrarr;</a></p>
				</div>
			</div>
			<div class="content__item" id="content-3">
				<img class="content__item-img rounded-right" src="${pageContext.request.contextPath}/resources/images/macbook-content.jpg" alt="MacBook Content" />
				<div class="content__item-inner">
					<h2>The MacBook</h2>
					<h3>It's the future of the notebook</h3>
					<p>With the new MacBook, we set out to do the impossible: engineer a full-size experience into the lightest and most compact Mac notebook ever. That meant reimagining every element to make it not only lighter and thinner but also better. The result is more than just a new notebook. It's the future of the notebook.</p>
					<p><a href="https://www.apple.com/macbook/design/">Learn more about the design &xrarr;</a></p>
				</div>
			</div>
			<div class="content__item" id="content-4">
				<img class="content__item-img rounded-right" src="${pageContext.request.contextPath}/resources/images/imac-content.jpg" alt="iMac Content" />
				<div class="content__item-inner">
					<h2>The iMac</h2>
					<h3>Engineered to the very last detail</h3>
					<p>Every new Mac comes with Photos, iMovie, GarageBand, Pages, Numbers, and Keynote. So you can be creative with your photos, videos, music, documents, spreadsheets, and presentations right from the start. You also get great apps for email, surfing the web, sending texts, and making FaceTime calls - there��s even an app for finding new apps.</p>
					<p><a href="https://www.apple.com/imac/built-in-apps/">Learn more about the iMac's features &xrarr;</a></p>
				</div>
			</div>
			<div class="content__item" id="content-5">
				<img class="content__item-img rounded-right" src="${pageContext.request.contextPath}/resources/images/apple-watch-content.png" alt="Apple Watch Content" />
				<div class="content__item-inner">
					<h2>The Apple Watch</h2>
					<h3>Entirely new ways to stay in touch</h3>
					<p>Apple Watch makes all the ways you're used to communicating more convenient. And because it sits right on your wrist, it can add a physical dimension to alerts and notifications. For example, you��ll feel a gentle tap with each incoming message. Apple Watch also lets you connect with your favorite people in fun, spontaneous ways - like sending a tap, a sketch, or even your heartbeat. </p>
					<p><a href="https://www.apple.com/watch/new-ways-to-connect/">Learn more about new ways to connect &xrarr;</a></p>
				</div>
			</div>
			<button class="button button--close"><i class="icon icon--circle-cross"></i><span class="text-hidden">Close content</span></button>
		</section>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/classie.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/dynamics.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>