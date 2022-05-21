async function removeItem(itemId) {
	let success = await removeFromServer(itemId);

	if (success) {
		removeFromPage(itemId);
	}
}

async function removeFromServer(itemId) {
	let response = await fetch(`?id=${itemId}`, { method: 'DELETE' });

	if (response.status === 200) {
		return true;
	} else {
		alert(`Ajax call failed. Please check the console. Error code ${response.status}.`);
		console.log(response);
		return false;
	}
}

function removeFromPage(itemId) {
	let elementId = `item-${itemId}`;
	let element = document.getElementById(elementId);

	if (element !== null) {
		element.remove();
		return true;
	} else {
		alert(`Could not find element by id "${elementId}"`);
		return false;
	}
}