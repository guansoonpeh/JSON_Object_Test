package com.example.json_object_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.json_object_test.databinding.ActivityMainBinding
import com.example.json_object_test.myrecyclerview.ContactAdapter
import com.example.json_object_test.myrecyclerview.ContactInfo
import org.json.JSONArray
import org.json.JSONObject
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactList: ArrayList<ContactInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactList = loadContact()

        val adapter = ContactAdapter(contactList)

        binding.contactRecyclerView.adapter = adapter
        binding.contactRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.contactRecyclerView.setHasFixedSize(true)

    }

    fun loadContact(): ArrayList<ContactInfo>{
        val str_response =  """
            {"info":[
               {"name":"Ajay","id":"111","email":"ajay@gmail.com"},
               {"name":"John","id":"112","email":"john@gmail.com"},
               {"name":"Rahul","id":"113","email":"rahul@gmail.com"},
               {"name":"Maich","id":"114","email":"maich@gmail.com"},
               {"name":"Vikash","id":"115","email":"vikash@gmail.com"},
               {"name":"Mayank","id":"116","email":"mayank@gmail.com"},
               {"name":"Prem","id":"117","email":"prem@gmail.com"},
               {"name":"Chandan","id":"118","email":"chandan@gmail.com"},
               {"name":"Soham","id":"119","email":"soham@gmail.com"},
               {"name":"Mukesh","id":"120","email":"mukesh@gmail.com"},
               {"name":"Ajad","id":"121","email":"ajad@gmail.com"}
            ]}
        """



        //creating json object
        val json_contact: JSONObject = JSONObject(str_response)

        //creating json array
       var jsonarray_info: JSONArray = json_contact.getJSONArray("info")
        var i:Int = 0
        var size:Int = jsonarray_info.length()



        var arrayList = arrayListOf<ContactInfo>()

        for (i in 0.. size-1) {
            var json_objectdetail:JSONObject = jsonarray_info.getJSONObject(i)

            val contactInfo = ContactInfo()

            contactInfo.id = json_objectdetail.getString("id")
            contactInfo.name = json_objectdetail.getString("name")
            contactInfo.email = json_objectdetail.getString("email")

            arrayList.add(contactInfo)
        }


        return arrayList

    }

}