package com.slabiak.controllers;

import com.slabiak.service.ApiManager;
import com.slabiak.service.ApiService;
import com.slabiak.utility.PrimesHelper;
import com.slabiak.model.ApiResponse;
import retrofit2.Call;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/primes")
public class PrimesController extends HttpServlet {


    protected void doGet(final HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApiService apiService = ApiManager.getClient();
        Call<ApiResponse> call = apiService.getNumbers();

        try {
            ApiResponse apiResponse = call.execute().body();

            List<Integer> data = apiResponse.getData();
            List<Integer> sortedData = PrimesHelper.sortPrimes(data);
            ArrayList<Integer> uniqueData = PrimesHelper.removeDuplicates(sortedData);
            ArrayList<Integer> filteredData = PrimesHelper.filterPrimes(uniqueData);

            request.setAttribute("id", apiResponse.getId());
            request.setAttribute("totalSize", data.size());
            request.setAttribute("primesSize", filteredData.size());
            request.setAttribute("primesList", filteredData);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", e.toString());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
