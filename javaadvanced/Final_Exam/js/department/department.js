function viewDepartmentList() {
    $(".main").load("./department/departmentPage.html", function() {
        // console.log(1);
        setupSearchEventDepartment();
        setupFilterDepartment();
        buildDepartmentTable();
    });

}

function buildDepartmentTable() {
    $('#mytable tbody').empty();
    getListDepartments();
}

var departments = [];



// paging
var currentDepartmentPage = 1;
var sizeDepartment = 5;

// sorting
var sortFieldDepartment = "id";
var isDepartmentAsc = false;

// getList
function getListDepartments() {
    var url = "http://localhost:8080/api/v1/departments";

    // paging
    url += '?page=' + currentDepartmentPage + '&size=' + sizeDepartment;

    // sorting 
    url += "&sort=" + sortFieldDepartment + "," + (isDepartmentAsc ? "asc" : "desc");

    // search
    var search = document.getElementById("search-department-input").value;
    if (search) {
        url += "&search=" + search;
    }

    // filter
    var minCreateDate = document.getElementById("filter-min-date-select").value;
    if (minCreateDate) {
        url += "&minCreateDate=" + minCreateDate;
    }

    var maxCreateDate = document.getElementById("filter-max-date-select").value;
    if (maxCreateDate) {
        url += "&maxCreateDate=" + maxCreateDate;
    }
    var type = document.getElementById("filter-type-select").value;
    if (type) {
        url += "&type=" + type;
    }

    // call API from server
    $.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            // success
            departments = data.content;
            fillDepartmentToTable();
            fillDepartmentPaging(data.numberOfElements, data.totalPages);
            fillDepartmentSorting();
        },
        error(jqXHR, textStatus, errorThrown) {
            alert("You are not authorized to view this page");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}

function fillDepartmentToTable() {
    departments.forEach(function(item, index) {
        $('#mytable tbody').append(
            '<tr>' +
            '<td> ' +
            '<span class="department-checkbox"> ' +
            '<input id="checkbox-' + index + '" type="checkbox" onClick="onChangeDepartmentCheckboxItem()"/>' +
            '<label></label>' +
            '</span>' +
            '</td>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.totalMember + '</td>' +
            '<td>' + item.type + '</td>' +
            '<td>' + item.createDate + '</td>' +

            '<td class="td-actions"> ' +
            '<a href="#" data-toggle="tooltip" title="Add accounts" onclick="openAddAccountsToDepartmentModal(' + item.id + ', \'' + item.name + '\', \'' + item.type + '\')"><i class="fa-solid fa-plus"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Edit" onclick="showDepartmentModal(' + item.id + ')"><i class="fa-solid fa-pencil"></i></a>' +
            '<a href="#" data-toggle="tooltip" title="Devare" onclick="showDeleteSingleDepartmentModal(' + item.id + ', \'' + item.name + '\')"><i class="fa-regular fa-trash-can"></i></a>' +
            '</td>' +
            '</tr>'
        );
    });

}

// paging 
function fillDepartmentPaging(currentSize, totalPages) {
    // prvevios
    if (currentDepartmentPage > 1) {
        document.getElementById("department-previousPage-btn").disabled = false;

    } else {
        document.getElementById("department-previousPage-btn").disabled = true;
    }

    // next 
    if (currentDepartmentPage < totalPages) {
        document.getElementById("department-nextPage-btn").disabled = false;

    } else {
        document.getElementById("department-nextPage-btn").disabled = true;
    }

    // text
    document.getElementById("department-page-info").innerHTML = sizeDepartment + (sizeDepartment > 1 ? " records " : " record ") + currentDepartmentPage + " of " + totalPages;

}

function prveviosDepartmentPage() {
    changeDepartmentPage(currentDepartmentPage - 1);
    document.getElementById("checkbox-all").checked = false;
}

function nextDepartmentPage() {
    changeDepartmentPage(currentDepartmentPage + 1);
    document.getElementById("checkbox-all").checked = false;
}

function changeDepartmentPage(page) {
    currentDepartmentPage = page;
    buildDepartmentTable();
}

// Sorting
function fillDepartmentSorting() {
    var sortTypeClazz = isDepartmentAsc ? "fa-sort-up" : "fa-sort-down";
    var defaultSortType = "fa-sort";

    switch (sortFieldDepartment) {
        case 'name':
            changeDepartmentIconSort("name-sort", sortTypeClazz);
            changeDepartmentIconSort("totalMember-sort", defaultSortType);
            changeDepartmentIconSort("createDate-sort", defaultSortType);

            break;
        case 'totalMember':
            changeDepartmentIconSort("name-sort", defaultSortType);
            changeDepartmentIconSort("totalMember-sort", sortTypeClazz);
            changeDepartmentIconSort("createDate-sort", defaultSortType);

            break;
        case 'createDate':
            changeDepartmentIconSort("name-sort", defaultSortType);
            changeDepartmentIconSort("totalMember-sort", defaultSortType);
            changeDepartmentIconSort("createDate-sort", sortTypeClazz);

            break;
            // sort by id;
        default:
            changeDepartmentIconSort("name-sort", defaultSortType);
            changeDepartmentIconSort("totalMember-sort", defaultSortType);
            changeDepartmentIconSort("createDate-sort", defaultSortType);

            break;
    }
}

function changeDepartmentIconSort(id, sortTypeClazz) {
    document.getElementById(id).classList.remove("fa-sort", "fa-sort-up", "fa-sort-down");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function changeDepartmentSort(field) {
    if (field == sortFieldDepartment) {
        isDepartmentAsc = !isDepartmentAsc;
    } else {
        sortFieldDepartment = field;
        isDepartmentAsc = true;
    }
    buildDepartmentTable();
}

// search

function setupSearchEventDepartment() {
    $("#search-department-input").on("keyup", function(event) {
        // enter key code = 13
        if (event.keyCode === 13) {
            buildDepartmentTable();
        }
    });
}

// filter
function filterDepartment() {
    // console.log(1);  
    buildDepartmentTable();

}

// set up filter
function setupFilterDepartment() {
    setupMinDate();
    setupMaxDate();
    setupType();
}


// setup min date
function setupMinDate() {
    document.getElementById('filter-min-date-select').max = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
}

// setup max date
function setupMaxDate() {
    document.getElementById('filter-max-date-select').max = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
    document.getElementById('filter-max-date-select').value = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
}

function setupType() {
    $("#filter-type-select").select2({
        placeholder: "Select a type"
    });
}

// Re fresh Table
function refreshDepartmentList() {
    // refresh paging
    currentDepartmentPage = 1;
    sizeDepartment = 5;

    // refresh sorting
    sortFieldDepartment = "id";
    isDepartmentAsc = false

    // refresh search
    document.getElementById("search-department-input").value = "";

    // refresh filter
    document.getElementById('filter-min-date-select').value = "";
    document.getElementById('filter-max-date-select').value = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().split("T")[0];
    $('#filter-type-select').val('').trigger('change');

    // resfresh checkbox
    document.getElementById("checkbox-all").checked = false;


    /// Get API
    buildDepartmentTable();
}

// delete sing department
function showDeleteSingleDepartmentModal(id, name) {
    $('#deleteSingleDepartmentModal').modal('show');
    document.getElementById('delete-single-department-confirm-mess').innerHTML = 'Bạn có muốn xóa. Delete <span style="color:red;">' + name + '</span>?';
    document.getElementById('delete-single-department-btn').onclick = function() { deleteSingleDepartment(id) };
}
// delete single department
function deleteSingleDepartment(id) {
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }

            // success
            $('#deleteSingleDepartmentModal').modal('hide');
            showSuccessSnackBar("Success! department deleted.");
            re();
        }
    });
}

// delete multiple department
function onChangeDepartmentCheckboxAll() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            checkboxItem.checked = document.getElementById("checkbox-all").checked
            i++;
        } else {
            break;
        }
    }
}

function onChangeDepartmentCheckboxItem() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (!checkboxItem.checked) {
                document.getElementById("checkbox-all").checked = false;
                return;
            }
            i++;
        } else {
            break;
        }
    }
    document.getElementById("checkbox-all").checked = true;
}

function showDeleteMultipleDepartmentsModal() {
    $('#deleteMultipleDepartmentsModal').modal('show');

    // get checked
    var ids = [];
    var names = [];
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (checkboxItem.checked) {
                ids.push(departments[i].id);
                names.push(departments[i].name);
            }
            i++;
        } else {
            break;
        }
        if (!ids || ids.length == 0) {
            document.getElementById('delete-departments-confirm-mess').innerHTML = 'Choose at least one department to delete!';
            document.getElementById('delete-multiple-departments-btn').style.display = 'none';
        } else {
            document.getElementById('delete-departments-confirm-mess').innerHTML = 'This action can not be undone. Delete <span id="name-delete-message"></span>?';
            document.getElementById('name-delete-message').innerHTML += '<span style="color: red;">' + names.join(", ") + '</span> (<span style="color: red;">' + names.length + '</span> ' + (names.length == 1 ? 'department' : 'department') + ')';
            document.getElementById('delete-multiple-departments-btn').style.display = 'inline-block';
            document.getElementById('delete-multiple-departments-btn').onclick = function() { deleteMultipleDepartments(ids) };
        }
    }
}


function deleteMultipleDepartments(departmentIds) {
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/?ids=' + departmentIds.toString(),
        type: 'DELETE',
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;

            }

            // sucess
            showSuccessSnackBar("Success! Department deleted.");
            $('#deleteMultipleDepartmentsModal').modal('hide');
            buildDepartmentTable();
        }
    });
}




function openDepartmentModal() {
    $('#addAndUpdateDepartmentModal').modal('show');
}

function hideDepartmentModal() {
    $('#addAndUpdateDepartmentModal').modal('hide');
}

// open create modal
function openAddDepartmentModal() {
    openDepartmentModal();

    // enable name input
    $("#modal-department-name").prop('disabled', false);

    resetAddDepartmentForm();
}

// save
function saveDepartment() {
    var id = document.getElementById("department-id").value;
    if (!id) {
        addDepartment();
    } else {
        updateDepartment();

    }
}

function isValidName(name) {
    if (!name) {
        // show error message
        showErrorMessage("Department name is exists!");
        return false;
    }

    // validate format
    var regex = new RegExp('^(?=.*[a-z])[a-zA-Z0-9_.-]{6,50}$');

    if (!regex.test(name)) {
        showErrorMessage("Department name is exists!");
        return false;
    };
    hideErrorMessage("modal-department-input-errMess-name", "modal-department-name");
    return true;
}

function isValidType(type) {
    if (!type) {
        // show error message
        showErrorMessage("modal-department-input-errMess-type", "modal-type-select", errors_messages_type);
        return false;
    };
    hideErrorMessage("modal-department-input-errMess-type", "modal-type-select");
    return true;
}

// reset error message
function resetDepartmentModalErrMessage() {
    hideErrorMessage("modal-department-input-errMess-name", "modal-department-name");
    hideErrorMessage("modal-department-input-errMess-type", "modal-type-select");

}

// update showDepartmentModal1
function showDepartmentModal(id) {

    // reset error message
    resetDepartmentModalErrMessage();

    // Disable Department name input
    $("#modal-department-name").prop('disabled', true);

    // show Modal
    openDepartmentModal();


    document.getElementById("department-id").value = id;
    departments.forEach(element => {
        if (element.id == id) {
            document.getElementById("modal-department-name").value = element.name;
            document.getElementById("modal-type-select").value = element.type;
        }
    });

    document.getElementById("addAndUpdateDepartment-modal-title").innerHTML = "Update Department";
}

function showErrorMessage(message) {
    console.log("error");
    document.getElementById("nameErrorMessage").style.display = "block";
    document.getElementById("nameErrorMessage").innerHTML = message;
}

function hideErrorMessage() {
    // console.log(1);
    // document.getElementById("nameErrorMessage").style.display = "none";
}

// update

function updateDepartment() {
    var id = document.getElementById("department-id").value;
    var type = document.getElementById("modal-type-select").value;

    var department = {
        "type": type
    }
    console.log(departments);
    departments.forEach(department => {
        if (department.id == id && department.type == type) {
            showSuccessSnackBar("Success! Department updated. asdascdasda");
            hideDepartmentModal();
            refreshDepartmentList();
            return;
        }
    });


    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'PUT',
        data: JSON.stringify(department),
        contentType: "application/json",
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            showSuccessSnackBar("Success! Department updated.");
            hideDepartmentModal();
            refreshDepartmentList();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

// CreateDepartment
var errors_messages_name = "name must be from 6 to 50 characters!";
var errors_messages_name_exists = "name already exists!";
var errors_messages_type = "You must choose type!";

function addDepartment() {
    var name = document.getElementById("modal-department-name").value;
    var type = document.getElementById("modal-type-select").value;

    // validate
    // var validName = isValidName(name);
    // var validType = isValidType(type);

    // // format
    // if (!validName || !validType) {
    //     return;
    // }

    /// check name unique
    $.ajax({
        url: "http://localhost:8080/api/v1/departments/name/" + name + "/exists",
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            // success
            if (data) {
                // show error message
                showFieldErrorMessageDepartmentModal("modal-input-errMess-departmentName", "modal-department-name", error_message_departmentName_exists);
                return;
            } else {
                createDepartmentViaAPI(name, type);

            }
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

}

function createDepartmentViaAPI(name, type) {
    // call api create department
    var newDepartment = {
        "name": name,
        "type": type
    }
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(newDepartment), // body
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        contentType: "application/json", // type of body (json, xml, text)
        success: function(data, textStatus, xhr) {
            // success
            showSuccessSnackBar("Success! New department created!");
            hideDepartmentModal();
            buildDepartmentTable();
            resetAddDepartmentForm();
        },
        error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}


function resetAddDepartmentForm() {
    // set title
    document.getElementById("addAndUpdateDepartment-modal-title").innerHTML = "Create New Department";

    // Reset all input value 
    document.getElementById("modal-department-name").value = "";
    document.getElementById("modal-type-select").value = "Pick a type";


    // Reset all error message
    resetDepartmentModalErrMessage();

}

var checkedAccountIds = [];
// Add account to sale
function openAddAccountsToDepartmentModal(id, name, type) {
    $('#addAccountsToDepartmentModal').modal('show');

    document.getElementById("addAccountToDepartment-modal-title").innerHTML = "Add account to " + name;
    // getAccountByNullDepartment();
    buildAccountByNullDepartment();
}

function buildAccountByNullDepartment() {
    $('#department-accounts-table tbody').empty();
    getAccountByNullDepartment();
}

var nullDepartmentAccounts = [];

// paging account to department
var currentAccountByDepartmentPage = 1;
var sizeAccountByDepartment = 5;


// sorting
var modalAccountSortField = "id";
var modalAccount_isAsc = false;

function getAccountByNullDepartment() {
    var url = "http://localhost:8080/api/v1/accounts/department/null";

    // paging
    url += '?page=' + currentAccountByDepartmentPage + '&size=' + sizeAccountByDepartment;
    // sorting
    url += "&sort=" + modalAccountSortField + "," + (modalAccount_isAsc ? "asc" : "desc");
    // call API from server
    $.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            // success
            nullDepartmentAccounts = data.content;
            fillAccountByNullDepartment();
            fillModalAccountPaging(data.numberOfElements, data.totalPages);
            fillModalAccountSorting();
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function fillAccountByNullDepartment() {
    nullDepartmentAccounts.forEach(function(item, index) {
        $('#modal-accounts-table tbody').append(
            '<tr>' +
            '<td> ' +
            '<span class="modal-accounts-checkbox"> ' +
            '<input id="modal-accounts-checkbox-' + index + '" type="checkbox" onClick="onChangeModalAccountCheckboxItem()"/>' +
            '<label></label>' +
            '</span>' +
            '</td>' +
            '<td>' + item.username + '</td>' +
            '<td>' + item.fullName + '</td>' +
            '<td>' + item.role + '</td>' +
            '</tr>'
        );
    });

    // get checked box if account is checked 
    checkedAccountIds.forEach(id => {
        for (let index = 0; index < nullDepartmentAccounts.length; index++) {
            const element = nullDepartmentAccounts[index];
            if (id == element.id) {
                var checkboxItem = document.getElementById("modal-accounts-checkbox-" + index);
                checkboxItem.checked = true;
            }
        }
    });
}


// paging
function fillModalAccountPaging() {
    // previos
    if (currentAccountByDepartmentPage > 1) {
        document.getElementById("modal-account-prevPage-btn").disabled = false;
    } else {
        document.getElementById("modal-account-prevPage-btn").disabled = true;
    }

    // next
    if (currentAccountByDepartmentPage < totalPages) {
        document.getElementById("modal-account-nextPage-btn").disabled = false;
    } else {
        document.getElementById("modal-account-nextPage-btn").disabled = true;
    }

    // text
    document.getElementById("modal-accounts-page-info").innerHTML = sizeAccountByDepartment + (sizeAccountByDepartment > 1 ? " records, " : " record, ") + currentAccountByDepartmentPage + " of " + totalPages;
}


function prevModalAccountPage() {
    // reset checkbox all 
    document.getElementById("modal-accounts-checkbox-all").checked = false;

    // get  checked account ids 
    getCheckedAccountIds();
    console.log(checkedAccountIds);
    changeModalAccountPage(currentAccountByDepartmentPage - 1);
}

function nextModalAccountPage() {
    // reset checkbox all 
    document.getElementById("modal-accounts-checkbox-all").checked = false;
    // get checked account ids 
    getCheckedAccountIds();
    console.log(checkedAccountIds);

    changeModalAccountPage(currentAccountByDepartmentPage + 1);
}

function changeModalAccountPage(page) {
    currentAccountByDepartmentPage = page;
    buildAccountByNullDepartment();
}
// get checked account ids 
function getCheckedAccountIds() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("modal-accounts-checkbox-all" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (checkboxItem.checked) {
                checkedAccountIds.push(nullDepartmentAccounts[i].id);
            } else {
                checkedAccountIds = checkedAccountIds.filter(function(item) {
                    return item !== nullDepartmentAccounts[i].id
                })
            }
            i++;
        } else {
            break;
        }
    }
    checkedAccountIds = checkedAccountIds.filter((item, i, ar) => ar.indexOf(item) === i);
}
// sorting modal account 
function fillModalAccountSorting() {
    var sortTypeClazz = account_isAsc ? "fa-sort-up" : "fa-sort-down";
    var defaultSortType = " fa-sort";

    switch (modalAccountSortField) {
        case 'username':
            // show sort type
            changeIconSortModalAccount("modal-username-sort", sortTypeClazz);
            changeIconSortModalAccount("modal-fullname-sort", defaultSortType);

            // custom css
            $('#modal-accounts-th-username a, #modal-accounts-th-username i').css('color', '#fe6100');
            $('#modal-accounts-th-full-name a, #modal-accounts-th-full-name i').css('color', '#000');
            break;
        case 'fullName':
            // show sort type
            changeIconSortModalAccount("modal-username-sort", defaultSortType);
            changeIconSortModalAccount("modal-fullname-sort", sortTypeClazz);

            // custom css
            $('#modal-accounts-th-username a, #modal-accounts-th-username i').css('color', '#000');
            $('#modal-accounts-th-full-name a, #modal-accounts-th-full-name i').css('color', '#fe6100');
            break;

            // sort by id
        default:
            changeIconSortModalAccount("modal-username-sort", defaultSortType);
            changeIconSortModalAccount("modal-fullname-sort", defaultSortType);

            // custom css
            $('#modal-accounts-th-username a, #modal-accounts-th-username i').css('color', '#000');
            $('#modal-accounts-th-full-name a, #modal-accounts-th-full-name i').css('color', '#000');
            break;
    }
}

function changeIconSortModalAccount(id, sortTypeClazz) {
    document.getElementById(id).classList.remove("fa-sort", "fa-sort-up", "fa-sort-down");
    document.getElementById(id).classList.add(sortTypeClazz);
}

function changeModalAccountSorting(field) {
    if (field == modalAccountSortField) {
        modalAccount_isAsc = !modalAccount_isAsc;
    } else {
        modalAccountSortField = field;
        modalAccount_isAsc = true;
    }
    buildAccountByNullDepartment();
}

// checking box 
function onchangeAccountToDepartmentCheckBoxAll() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("modal-accounts-checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            checkboxItem.checked = document.getElementById("modal-accounts-checkbox-all").checkeds
            i++;
        } else {
            break;
        }
    }
}


function onChangeAccountDepartmentNullCheckboxItem() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("modal-accounts-checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (!checkboxItem.checked) {
                document.getElementById("modal-accounts-checkbox-all").checkeds = false;
                return;
            }
            i++;
        } else {
            break;
        }
    }
    document.getElementById("modal-accounts-checkbox-all").checkeds = true;
}

// create department and accounts to deparmtent
function saveAccountToDepartment(name, type) {
    getCheckedAccountIds();
    console.log(checkedAccountIds);

    // get department id 
    var id = document.getElementById("addAccountToDepartmentModal-department-id").value;
    if (!id) {
        createDepartmentViaAPI(name, type);
    }
}

function createDepartment(name, type) {
    // call api create department
    var newDepartment = {
        "name": name,
        "type": type,
        "accountIds": checkedAccountIds
    }
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments',
        type: 'POST',
        data: JSON.stringify(newDepartment), // body
        contentType: "application/json", // type of body (json, xml, text)
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
        },
        success: function(data, textStatus, xhr) {
            // success
            hideAddAccountsToDepartmentModal();
            hideDepartmentModal();
            showSuccessSnackBar("Success! New department created!");
            buildDepartmentTable();
        },
        error(jqXHR, textStatus, errorThrown) {
            alert("Error when loading data");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}

function hideAddAccountsToDepartmentModal() {
    $('#addAccountsToDepartmentModal').modal('hide');
}