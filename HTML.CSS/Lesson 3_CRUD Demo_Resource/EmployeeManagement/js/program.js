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
// khai báo danh sách nhân viên 
var employees = [];
var counter = 0;


// Hàm khởi tạo đối tượng Employee
function Employee(name, department, phone) {
    this.id = ++counter;
    this.name = name;
    this.department = department;
    this.phone = phone;
}

// Hàm khởi tạo ra các dữ liệu employee
function initEmployees() {
    if (null == employees || employees.length == 0) {
        // init data
        employees.push(new Employee("Lê Văn Tùng", "DEV", "0569679480"));
        employees.push(new Employee("Nguyễn Đăng Bảy", "TestTer", "01499635"));
        employees.push(new Employee("Bùi Văn Điệu", "PM ", "069875663"));
        employees.push(new Employee("Nguyễn Minh Anh", "BA ", "0258463"));
        employees.push(new Employee("Phạm Yến Thanh", "DevOps ", "014258"));
        employees.push(new Employee("Vũ Chiến Thành", "Leadear", "0968753"));
        employees.push(new Employee("Lê Thanh Vân", "senior", "0568762"));
    }
}

// Hàm dùng để in ra danh sách employee lên table html 
function buildTable() {
    setTimeout(function name(params) {

        $('tbody').empty();
        // initEmployees();

        // employees.forEach(function(item) {
        //     $('tbody').append(
        //         '<tr>' +
        //         '<td>' + item.name + '</td>' +
        //         '<td>' + item.department + '</td>' +
        //         '<td>' + item.phone + '</td>' +
        //         '<td>' +
        //         '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
        //         '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
        //         '</td>' +
        //         '</tr>')
        // });
        $.get("https://61da63abce86530017e3cd3a.mockapi.io/user" , function(data , status){
            data.forEach(function (item){
                $('tbody').append(
                            '<tr>' +
                            '<td>' + item.name + '</td>' +
                            '<td>' + item.department + '</td>' +
                            '<td>' + item.phone + '</td>' +
                            '<td>' +
                            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
                            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
                            '</td>' +
                            '</tr>')
                   
            });
        })
    }, 00);
}

function openAddModal() {
    resetForm();
     document.getElementById("title_modal").innerHTML = "Thêm mới nhân viên";
    openModal();
}

// Hàm đưa  các trường  
function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("department").value = "";
    document.getElementById("phone").value = "";
}


// Hàm hiện thị modal
function openModal() {
    $('#myModal').modal('show');
}


// Hàm ẩn modal
function hideModal() {
    $('#myModal').modal('hide');
}


// Hàm để thêm 1 employee vào danh sách:
function addEmployee() {
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    // TODO validate
    // then fail validate ==> return;

    employees.push(new Employee(name, department, phone));

    hideModal();
    showSuccessAlert();
    buildTable();
}


// Mở ra modal của đối tượng cần sửa thông tin 
function openUpdateModal(id) {
    document.getElementById("title_modal").innerHTML = "Sửa thông tin nhân viên";
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);

    // fill data
    document.getElementById("id").value = employees[index].id;
    document.getElementById("name").value = employees[index].name;
    document.getElementById("department").value = employees[index].department;
    document.getElementById("phone").value = employees[index].phone;

    openModal();
}

// Hàm chức năng cho nút save ở Modal
function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addEmployee();
    } else {
        updateEmployee();
    }
}

// Hàm update thông tin của 1 employee
function updateEmployee() {


    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var department = document.getElementById("department").value;
    var phone = document.getElementById("phone").value;

    // TODO validate
    // then fail validate ==> return;

    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);

    // update employee
    employees[index].name = name;
    employees[index].department = department;
    employees[index].phone = phone;

    hideModal();
    showSuccessAlert();
    buildTable();
}

// Hàm thực hiện cofim trước khi xóa 
function openConfirmDelete(id) {
    // get index from employee's id
    var index = employees.findIndex(x => x.id == id);
    var name = employees[index].name;

    var result = confirm("Bạn có chắc chắn muốn xóa  " + name + " ra khỏi danh sách không ?");
    if (result) {
        deleteEmployee(id);
    }
}


// Hàm xóa đi 1 employee
function deleteEmployee(id) {
    // TODO validate
    var index = employees.findIndex(x => x.id === id);
    employees.splice(index, 1);

    showSuccessAlert();
    buildTable();
}


// Hàm để thông báo khi delete thành công 
function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}