import React, { useState } from "react";
import SVClientDataService from "../../services/svclient.data.service";

export default function UserDetails() {
  const [users, setUsers] = useState([]);

  const getUserList = (dataService) => {
    dataService
      .getUsers()
      .then((response) => {
        setUsers(response.data);
      })
      .catch((e) => {
        console.log(e);
      });
  };
  getUserList(SVClientDataService);
  return (
    <div>
      <h1>Available Resources</h1>
      <div>
        <table>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthdate</th>
          </tr>
          {users.map((person) => (
            <tr>
              <td>{person.id}</td>
              <td>{person.username}</td>
              <td>{person.birthdate}</td>
            </tr>
          ))}
        </table>
      </div>
    </div>
  );
}

// function getUsersList() {
//   SVClientDataService.getUsers()
//     .then((response) => {
//       this.setUsers(response.data);
//     })
//     .catch((e) => {
//       console.log(e);
//     });
// }
