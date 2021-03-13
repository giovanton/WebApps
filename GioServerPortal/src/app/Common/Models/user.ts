import { Role } from '../Models/role';
export class User{
        userGuid?: string;
        userName?: string;
        userLogin?: string;
        userEmail?: string;
        createdBy?: string;
        createdAt?: Date;
        modifiedBy?: string;
        updatedAt?: Date;
        roles?: Role[];
}
