import http from "../http-common";

class SVClientDataService {
  loadUsers() {
    return http.get("/dashboard");
  }
  getUsers() {
    return http.get("/users");
  }
}
export default new SVClientDataService();
