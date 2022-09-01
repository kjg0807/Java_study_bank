const addFiles = document.getElementById('addFiles'); // div id
const fileAdd = document.getElementById('fileAdd'); // button id
let count = 0;

fileAdd.addEventListener("click", function () {
    // <div class="mb-3">
    //   <label for="files" class="form-label">File</label>
    //   <input type="file" class="form-control" name="files" id="files">
    // </div>
    // div element
    let br = document.createElement('br');
    let div = document.createElement('div');
    // div - class value(mb-3)
    let divClass = document.createAttribute('class');
    divClass.value = "mb-3";
    div.setAttributeNode(divClass);

    // label element
    // label - for value(files) ..>File</label    
    let label = document.createElement("label");
    let labelClass = document.createAttribute("class");
    labelClass.value = "form-label";
    label.setAttributeNode(labelClass);

    let labelFor = document.createAttribute("for");
    labelFor.value = "files";
    label.setAttributeNode(labelFor);

    let labelText = document.createTextNode("File");
    labelText.value = "File";
    label.appendChild(labelText);

    div.appendChild(br);
    div.appendChild(label);

    //input element
    // input - type(file), class(form-control), name(files), id(files)
    let input = document.createElement("input");
    let inputType = document.createAttribute("type");
    inputType.value = "file";
    input.setAttributeNode(inputType);

    let inputClass = document.createAttribute("class");
    inputClass.value = "form-control";
    input.setAttributeNode(inputClass);

    let inputName = document.createAttribute("name");
    inputName.value = "files";
    input.setAttributeNode(inputName);

    let inputID = document.createAttribute("id");
    inputID.value = "files";
    input.setAttributeNode(inputID);

    div.appendChild(br);
    div.appendChild(input);
    
    count++;

    if(count > 5){
        alert("파일은 최대 5개까지만 가능합니다.");
        return;
    }

    addFiles.append(div);
})