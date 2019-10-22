package cn.medichains.cases;

import cn.medichains.config.TestConfig;
import cn.medichains.model.AddMedicineCase;
import cn.medichains.model.Medicine;
import cn.medichains.utils.DataBaseUtil;
import cn.medichains.utils.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class AddMedicineTest {

    @Test(dependsOnGroups = "loginTrue",description = "新增西药")
    public void testAddWestMedicine(){
        SqlSession session = null;
        try {
            session = DataBaseUtil.getSqlSession();
            //获取用例
            AddMedicineCase addMedicineCase = session.selectOne("addMedicineCase",1);
            String result = getResult(addMedicineCase);
            //验证接口返回状态
            JSONObject resultJson = JSONObject.parseObject(result);
            Assert.assertEquals(resultJson.getString("status"),addMedicineCase.getExpected());

            //验证数据插入的正确性
            Medicine medicine = session.selectOne("selectAddMedicine", addMedicineCase);
            Assert.assertNotNull(medicine);
        }catch (IOException e){
            session.rollback();
        }finally {
            session.close();
        }

    }

    String getResult(AddMedicineCase addMedicineCase) throws IOException {
        //header组装
        HashMap<String,String>headers = new HashMap<>();
        headers.put("Content-Type","application/json;charset=UTF-8");
        //参数组装
        JSONObject params = new JSONObject();
        params.put("medicineName",addMedicineCase.getMedicineName());
        params.put("tradeName",addMedicineCase.getTradeName());
        params.put("commonName", addMedicineCase.getCommonName());
        params.put("medicineAlias", addMedicineCase.getMedicineAlias());
        params.put("medicineType", addMedicineCase.getMedicineType());
        params.put("dosageForm", addMedicineCase.getDosageForm());
        params.put("dgmId", addMedicineCase.getDgmId());
        params.put("dgeId", addMedicineCase.getDgeId());
        params.put("dgfId", addMedicineCase.getDgfId());
        params.put("doseNumber", addMedicineCase.getDoseNumber());
        params.put("doseUnit", addMedicineCase.getDoseUnit());
        params.put("preparationNumber", addMedicineCase.getPreparationNumber());
        params.put("preparationUnit", addMedicineCase.getPreparationUnit());
        params.put("packagingUnit", addMedicineCase.getPackagingUnit());
        params.put("packagingDetail", addMedicineCase.getPackagingDetail());
        params.put("manufacturer", addMedicineCase.getManufacturer());
        params.put("basic", addMedicineCase.getBasic());
        params.put("antibiotic", addMedicineCase.getAntibiotic());
        params.put("antibioticType", addMedicineCase.getAntibioticType());
        params.put("standardCode", addMedicineCase.getStandardCode());
        params.put("approvalNumber", addMedicineCase.getApprovalNumber());
        params.put("costPrice", addMedicineCase.getCostPrice());
        params.put("retailPrice", addMedicineCase.getRetailPrice());
        params.put("resalePrice", addMedicineCase.getResalePrice());
        params.put("scattered", addMedicineCase.getScattered());
        params.put("scatterPrice", addMedicineCase.getScatterPrice());
        params.put("singleDose", addMedicineCase.getSingleDose());
        params.put("singleDoseUnit", addMedicineCase.getSingleDoseUnit());
        params.put("medicineUsage", addMedicineCase.getMedicineUsage());
        params.put("medicineFrequency", addMedicineCase.getMedicineFrequency());
        params.put("minInventories", addMedicineCase.getMinInventories());
        params.put("defaultDay", addMedicineCase.getDefaultDay());
        params.put("invoiceProject", addMedicineCase.getInvoiceProject());
        params.put("deleteFlag", addMedicineCase.getDeleteFlag());
        params.put("chainId", addMedicineCase.getChainId());
        //执行接口
        String result = HttpClientUtil.post(TestConfig.addMedicineUrl,params.toString(),headers);
        return result;
    }
}
