function ClickViewList() {
    $(".main").load("viewListAccount.html");
    buildTableAccount();
}

function buildTableAccount() {
    $('tbody').empty();
    // call API from server
    $.get("https://621111d601ccdac0741b85e4.mockapi.io/accounts", function(data, status) {

        if (status == "error") {
            //TODO
            alert("Error when loading data");
            return;
        }
        // assign list employess
        accounts = data;

        accounts.forEach(function(item) {
            $('tbody').append(
                '<tr>' +
                '<td>' + item.FristName + '</td>' +
                '<td>' + item.LastName + '</td>' +
                '<td>' + item.Gender + '</td>' +
                '<td>' +
                '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModalAccount(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
                '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDeleteAccount(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                '</td>' +
                '</tr>')
        });

    });
}

function openAddModalAccount() {
    resetFormAccount();
    openModalAccount();

}

function resetFormAccount() {
    document.getElementById("id").value = "";
    document.getElementById("FristName").value = "";
    document.getElementById("LastName").value = "";
    document.getElementById("Gender").value = "";
}

function openModalAccount() {
    $('#myModal').modal('show');
}

function hideModalAccount() {
    $('#myModal').modal('hide');
}

function addAccount() {
    var FristNameValue = document.getElementById("FristName").value;
    var LastNameValue = document.getElementById("LastName").value;
    var GenderValue = document.getElementById("Gender").value;

    // TODO validate
    // then fail validate ==> return;
    var accounts = {
        FristName: FristNameValue,
        LastName: LastNameValue,
        Gender: GenderValue
    };
    $.post("https://621111d601ccdac0741b85e4.mockapi.io/accounts", accounts, function(data, status) {
        // error
        if (status == "error") {
            alert("Error when loading data");
            return;
        }

        hideModalAccount();
        showSuccessAlert();
        buildTableAccount();
    });

}

function openUpdateModalAccount(id) {
    console.log(id);
    // get index from employee's id
    var index = accounts.findIndex(x => x.id == id);
    console.log(index);
    // fill data
    document.getElementById("id").value = accounts[index].id;
    document.getElementById("FristName").value = accounts[index].FristName;
    document.getElementById("LastName").value = accounts[index].LastName;
    document.getElementById("Gender").value = accounts[index].Gender;

    openModalAccount();
}

function saveAccount() {
    // console.log(2);
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addAccount();
    } else {
        updateAccount();
    }
}

function updateAccount() {
    // console.log(1);
    var id = document.getElementById("id").value;
    var FristNameValue = document.getElementById("FristName").value;
    var LastNameValue = document.getElementById("LastName").value;
    var GenderValue = document.getElementById("Gender").value;

    // TODO validate
    // then fail validate ==> return;

    var accounts = {
        FristName: FristNameValue,
        LastName: LastNameValue,
        Gender: GenderValue
    };
    $.ajax({
        url: 'https://621111d601ccdac0741b85e4.mockapi.io/accounts/' + id,
        type: 'PUT',
        data: accounts,
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }
            // success
            hideModalAccount();
            showSuccessAlert();
            buildTableAccount();

        }
    });
}


function openConfirmDeleteAccount(id) {
    // get index from employee's id
    var index = accounts.findIndex(x => x.id == id);
    var name = accounts[index].FristName;

    var reltset = confirm("Bạn có muốn xóa " + name + "?");
    if (reltset) {
        deleteAccount(id);
    }
}

function deleteAccount(id) {
    // TODO validate

    $.ajax({
        url: 'https://621111d601ccdac0741b85e4.mockapi.io/accounts/' + id,
        type: 'DELETE',
        success: function(reltset) {
            // error
            if (reltset == undefined || reltset == null) {
                alert("Error when loading data");
                return;
            }

            // success
            showSuccessAlert();
            buildTableAccount();
        }
    });

}

function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}