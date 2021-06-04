var script = document.createElement('script');
script.src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js";
document.getElementsByTagName('head')[0].appendChild(script);



function isSubmittable() {
	const regex = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

	if (regex.test($(".new > input[name='name']").val()) ||
		$(".new > input[name='name']").val().includes("[") ||
		$(".new > input[name='name']").val().includes("]") ||
		$(".new > input[name='name']").val().includes("(") ||
		$(".new > input[name='name']").val().includes(")")) {
		alert("이름에 특수 문자가 포함되어있습니다.");
		return false;

	} else if ($(".new > input[name='name']").val()
		!= jQuery.trim($(".new > input[name='name']").val())) {
		$(".new > input[name='name']").val(jQuery.trim($(".new > input[name='name']").val()));
		alert("이름의 앞뒤 공백을 제거했습니다.");
		return true;
	}
	return true;
};
