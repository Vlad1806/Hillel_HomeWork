package Service.Group;

import DAO.Group.GroupDAO;
import Entity.Group;

import java.util.List;

public class GroupService {

        private GroupDAO groupDAO = new GroupDAO();

        public void saveGroup(Group group) {
            groupDAO.save(group);
        }

        public void deleteGroup(Group group) {
            groupDAO.delete(group);
        }

        public void updateGroup(Group group) {
            groupDAO.update(group);
        }

        public List<Group> findAllGroups() {
            return groupDAO.findAll();
        }
    }
