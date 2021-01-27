	// Toggle between showing and hiding the sidebar, and add overlay effect
	function w3_open(id, overlay) {
		//var headerMenu = document.getElementById("headerMenu");
		var leftMoreOption = document.getElementById("leftMoreOption");
		var mainContent = document.getElementById("mainContent");
		var menu = document.getElementById(id);
		// Get the DIV with overlay effect
		var overlay = document.getElementById(overlay);
		if (menu.style.display === 'block') {
			menu.style.display = 'none';
			overlay.style.display = "none";
			if (id == 'sideMenu') {
				//headerMenu.style.marginLeft = "0px";
				mainContent.style.marginLeft = "0px";
				leftMoreOption.style.display = "inline-block";
				//document.getElementById("headerMenu").style.marginRight = "0px";
			}
		} else {
			menu.style.display = 'block';
			overlay.style.display = "block";
			if (id == 'sideMenu') {
				//headerMenu.style.marginLeft = "225px";
				mainContent.style.marginLeft = "225px";
				leftMoreOption.style.display = "none";
				//document.getElementById("headerMenu").style.marginRight = "225px";
			}
		}
	}

	function w3_close(id, overlay) {
		var headerMenu = document.getElementById("headerMenu");
		var leftMoreOption = document.getElementById("leftMoreOption");
		var mainContent = document.getElementById("mainContent");
		var menu = document.getElementById(id);
		// Get the DIV with overlay effect
		var overlay = document.getElementById(overlay);
		menu.style.display = "none";
		overlay.style.display = "none";
		if (id == 'sideMenu') {
			headerMenu.style.marginLeft = "0px";
			mainContent.style.marginLeft = "0px";
			leftMoreOption.style.display = "inline-block";
			//document.getElementById("headerMenu").style.marginRight = "0px";
		}
	}
	
	


	function myFunct(id, className) {
		var i;
		var element = document.getElementById(id);
		var x = document.getElementsByClassName(className);

		if (element.classList.contains("w3-show")) {
			element.classList.toggle("w3-show");
		} else {
			for (i = 0; i < x.length; i++) {
				x[i].className = element.className.replace("w3-show", "w3-hide");
			}
		element.classList.toggle("w3-show");
		}
	}
	
	
	function openTab(id, group) {
		  var i;
		  var x = document.getElementsByClassName(group);
		  for (i = 0; i < x.length; i++) {
		    x[i].style.display = "none";
		  }
		  document.getElementById(id).style.display = "block";
		}
	
