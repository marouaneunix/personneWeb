var tog = document.getElementById("tog");
var thing = document.getElementById("thing");
if(tog){
tog.addEventListener("click", function(){
	thing.classList.toggle("open");
});
}