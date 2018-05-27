function changeCondition(event,flag) {
	console.log("执行了");
	switch (flag) {
	case "0":
		queryConditionTemp.searchIsPay = event.value;
		showList();
		break;

	case "1":
		queryConditionTemp.searchIsRecharge=event.value;
		showList();
		break;
		
	case "2":
		queryConditionTemp.searchStreet=event.value;
		showList();
		break;
	case "3":
		queryConditionTemp.searchMethod=event.value;
		showList();
		break;
	default:
		break;
	}
}