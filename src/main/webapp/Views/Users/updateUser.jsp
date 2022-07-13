
<a class="dropdown-item" href="#" data-toggle="modal" data-target="#updateUser">Cập nhật tài khoản</a>

<!-- Modal -->
  <div class="modal fade" id="updateUser" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <p class="modal-title" id="exampleModalLabel" style="font-size: xx-large;">Cập nhật tài khoản</p>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <form action="/Assigment/" method="post">
          <div class="modal-body">
            <div class="card">
              <div class="card-body">
                <div class="form-group">
                  <label for="">Họ tên</label>
                  <input class="form-control" type="text" name="hoTen" id="" required>
                </div>
                <div class="form-group">
                  <label for="">Địa chỉ</label>
                  <input class="form-control" type="text" name="diaChi" id="" required>
                </div>
                <div class="form-group">
                  <label for="">Email</label>
                  <input class="form-control" type="email" name="email" id="" required>
                </div>
                <div class="form-group">
                  <label for="">SĐT</label>
                  <input class="form-control" type="number" name="sdt" id="" required>
                </div>
                <div class="form-group">
                  <label for="">Avatar</label>
                  <input class="form-control" type="file" name="avatar" id="" placeholder="Vui lòng chọn Avatar">
                </div>
              </div>
              <div class="card-footer text-center">
                <button class="btn btn-info">Cập nhật</button>
                <button class="btn btn-warning" type="reset">Reset</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>