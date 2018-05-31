/*
 * 查询账目信息
 */
function changeCondition(event, flag) {
	console.log("执行了");
	switch (flag) {
	case "0":
		queryConditionTemp.searchIsPay = event.value;
		showList();
		break;

	case "1":
		queryConditionTemp.searchIsRecharge = event.value;
		showList();
		break;

	case "2":
		queryConditionTemp.searchStreet = event.value;
		showList();
		break;
	case "3":
		queryConditionTemp.searchMethod = event.value;
		showList();
		break;
	case "4":
		queryConditionTemp.searchSort = event.value;
		showList();
		break;
	case "5":
		queryConditionTemp.searchTimeStart = event.value;
		showList();
		break;
	case "6":
		queryConditionTemp.searchTimeEnd = event.value;
		showList();
		break;
	default:
		break;
	}
}

function changeQuerySort() {
	queryConditionTemp.searchName = document.getElementById("searchName").value;
	queryConditionTemp.searchCommunity = document
			.getElementById("searchCommunity").value;
	showList();

}