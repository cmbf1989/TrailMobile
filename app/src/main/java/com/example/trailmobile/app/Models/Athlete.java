package com.example.trailmobile.app.Models;

import android.provider.BaseColumns;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.trailmobile.app.Interfaces.IModel;
import com.example.trailmobile.app.Interfaces.IUser;
import com.example.trailmobile.app.POJO.JsonResponse;
import com.example.trailmobile.app.POJO.User;

import java.util.List;

/**
 * Created by Cesar Ferreira on 20/03/2016.
 */

@Table(name = "User", id= BaseColumns._ID)
public class Athlete extends Model implements IUser,IModel
{

    // This is the unique id given by the server
    // This is a regular field
    @Column(name = "Name")
    public String name;

    @Column(name = "email")
    public String email;

    @Column(name = "phone")
    public String phone;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "weight")
    public Double weight;

    @Column(name = "gender")
    public String gender;

    @Column(name = "age")
    public int age;

    @Column(name = "bDeleted")
    public boolean bDeleted;

    @Column(name = "postal_code")
    public String postal_code;

    @Column(name = "address")
    public String address;

    @Column(name = "server_id")
    public long server_id;

    @Column(name = "identification_id")
    public String identification_id;

    // This is an association to another activeandroid model
    @Column(name = "idCategory", onUpdate = Column.ForeignKeyAction.CASCADE, onDelete = Column.ForeignKeyAction.CASCADE)
    public AthleteCategory category;

    // Make sure to have a default constructor for every ActiveAndroid model
    public Athlete(){
        super();
    }

    public Athlete(long remoteId, String name, AthleteCategory category){
        super();
        this.name = name;
        this.category = category;
    }

    public Athlete getAthleteById(long remoteId)
    {
        Athlete user = new Select()
                               .from(Athlete.class)
                               .where("_id = ?", remoteId)
                               .executeSingle();
        return user;
    }

    public Athlete getAthleteServerById(long remoteId)
    {
        Athlete user = new Select()
                .from(Athlete.class)
                .where("server_id = ?", remoteId)
                .executeSingle();
        return user;
    }

    public static Athlete getAthleteByCredentials(String email, String password)
    {
        Athlete user = new Select()
                .from(Athlete.class)
                .where("email = ?", email)
                //.where("server_id = ?", password)
                .executeSingle();
        return user;
    }
    public static List<Athlete> getAll() {
        return new Select()
                .from(Athlete.class)
                .execute();
    }


    @Override
    public <S>  boolean isCached(S id)
    {
        return getAthleteServerById((Long) id) != null;
    }

    @Override
    public <S> IModel saveUncached(S data)
    {
        try
        {

            User user = (User) data;
            long id = Long.valueOf(user.getAthleteId());

            if(!isCached(id)) {
                name = user.getName();
                email = user.getEmail();
                phone = user.getPhoneNumber1();
                address = user.getAddress();
                postal_code = user.getPostalCode();
                gender = user.getGender();
                server_id = Long.valueOf(user.getAthleteId());
                identification_id = user.getIdentificationId();
                save();
            } else {
                return getAthleteServerById(id);
            }
        } catch (Exception e ) {
            String etes = e.toString();
        }
        return this;
    }

    @Override
    public <S> IModel saveUncachedList(S data) {

        List<User> users = (List<User>) data;
        return  saveUncached(users.get(0));
    }

    @Override
    public long getModelId() {
        return getId();
    }
    // USER CATEGORY TABLE


    // USER ORGANIZATION TABLE


}
