function loadImage(event) {
    var input = event.target;
    var imgElement = document.getElementById('resultImage');
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            imgElement.src = e.target.result;
            imgElement.style.display = 'block'; /* Zeige das Bild an */
        };
        reader.readAsDataURL(input.files[0]);
    } else {
        imgElement.src = '';
        imgElement.style.display = 'none'; /* Verstecke das Bild */
    }
}
function createClassificationTable(classificationData) {
    var tableBody = document.getElementById('classificationTableBody');

    for (var i = 0; i < classificationData.length; i++) {
        var classItem = classificationData[i];
        var row = tableBody.insertRow();
        var classCell = row.insertCell();
        var probabilityCell = row.insertCell();

        classCell.innerText = classItem.className;
        probabilityCell.innerText = (classItem.probability * 100).toFixed(2) + '%';
    }
}

