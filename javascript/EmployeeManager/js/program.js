$(function() {
    $(".header").load("header.html");
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListEmployees() {
    $(".main").load("viewlistemployees.html");
    buildTable();
}

function buildTable() {
    $('tbody').empty();

    // call API from server
    $.get("https://621111d601ccdac0741b85e4.mockapi.io/employees", function(data, status) {
        if (status == "error") {
            //TODO
            alert("Error when loading data");
            return;
        }
        // assign list employees
        employees = data;

        employees.forEach(function(item) {
            $('tbody').append(
                '<tr>' +
                '<td>' + item.Name + '</td>' +
                '<td>' + item.Department + '</td>' +
                '<td>' + item.Phone + '</td>' +
                '<td>' +
                '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
                '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                '</td>' +
                '</tr>')
        });

    });
}





function openAddModal() {
    resetForm();
    openModal();
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("department").value = "";
    document.getElementById("phone").value = "";
}

function openModal() {
    $('#myModal').modal('show');
}

function hideModal() {
    $('#myModal').modal('hide');
}

function addEmployee() {
    var nameValue = document.getElementById("name").value;
    var departmentValue = document.getElementById("department").value;
    var phoneValue = document.getElementById("phone").value;

    // TODO validate
    // then fail validate ==> return;
    var employee = {
        Name: nameValue,
        Department: departmentValue,
        Phone: phoneValue
    };
    $.post("https://621111d601ccdac0741b85e4.mockapi.io/employees", employee, function(data, status) {
        // error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        hideModal();
        showSuccessAlert();
        buildTable();
    });

}

function openUpdateModal(id) {
    console.log(id);
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    console.log(index);
    // fill data
    document.getElementById("id").value = employees[index].id;
    document.getElementById("name").value = employees[index].Name;
    document.getElementById("department").value = employees[index].Department;
    document.getElementById("phone").value = employees[index].Phone;

    openModal();
}

function save() {
    // console.log(2);
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

function updateEmployee() {
    // console.log(1);
    var id = document.getElementById("id").value;
    var nameValue = document.getElementById("name").value;
    var departmentValue = document.getElementById("department").value;
    var phoneValue = document.getElementById("phone").value;

    // TODO validate
    // then fail validate ==> return;

    var employee = {
        Name: nameValue,
        Department: departmentValue,
        Phone: phoneValue
    };
    $.ajax({
        url: 'https://621111d601ccdac0741b85e4.mockapi.io/employees/' + id,
        type: 'PUT',
        data: employee,
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }
            // success
            hideModal();
            showSuccessAlert();
            buildTable();

        }
    });
}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].Name;

    var result = confirm("Bạn có muốn xóa " + name + "?");
    if (result) {
        deleteEmployee(id);
    }
}

function deleteEmployee(id) {
    // TODO validate

    $.ajax({
        url: 'https://621111d601ccdac0741b85e4.mockapi.io/employees/' + id,
        type: 'DELETE',
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            buildTable();
        }
    });

}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}